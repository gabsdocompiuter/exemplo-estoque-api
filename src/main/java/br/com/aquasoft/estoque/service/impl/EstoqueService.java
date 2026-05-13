package br.com.aquasoft.estoque.service.impl;

import br.com.aquasoft.estoque.dto.EstoqueLocalProdutoDto;
import br.com.aquasoft.estoque.dto.EstoqueProdutoDto;
import br.com.aquasoft.estoque.dto.MovimentacaoProdutoDto;
import br.com.aquasoft.estoque.dto.ProdutoDto;
import br.com.aquasoft.estoque.entity.EstoqueProdutoEntity;
import br.com.aquasoft.estoque.entity.LocalEstoqueEntity;
import br.com.aquasoft.estoque.entity.MovimentacaoEstoqueProdutoEntity;
import br.com.aquasoft.estoque.entity.ProdutoEntity;
import br.com.aquasoft.estoque.enums.TipoMovimentacaoEstoque;
import br.com.aquasoft.estoque.exceptions.BusinessException;
import br.com.aquasoft.estoque.repository.EstoqueProdutoRepository;
import br.com.aquasoft.estoque.repository.MovimentacaoEstoqueProdutoRepository;
import br.com.aquasoft.estoque.service.IEstoqueService;
import br.com.aquasoft.estoque.service.ILocalEstoqueService;
import br.com.aquasoft.estoque.service.IProdutoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstoqueService implements IEstoqueService {

    private final IProdutoService produtoService;
    private final ILocalEstoqueService localEstoqueService;

    private final EstoqueProdutoRepository estoqueProdutoRepository;
    private final MovimentacaoEstoqueProdutoRepository movimentacaoEstoqueProdutoRepository;

    @Override
    public EstoqueProdutoDto getEstoqueProduto(String codigoProduto) {
        ProdutoEntity produto = produtoService.findByCodigoBarras(codigoProduto)
                .orElseThrow(() -> new BusinessException("Produto não encontrado: " + codigoProduto));

        return getEstoqueProduto(produto);
    }

    @Override
    public EstoqueProdutoDto getEstoqueProduto(ProdutoEntity produto) {
        List<EstoqueProdutoEntity> estoqueList = estoqueProdutoRepository.findEstoqueProduto(produto);

        List<EstoqueLocalProdutoDto> estoqueLocalProdutoDtoList = estoqueList.stream()
                .map(EstoqueLocalProdutoDto::fromEntity)
                .toList();

        BigDecimal quantidadeTotal = estoqueList.stream()
                .map(EstoqueProdutoEntity::getQuantidadeEmEstoque)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );

        return EstoqueProdutoDto.builder()
                .produto(ProdutoDto.fromEntity(produto))
                .totalEmEstoque(quantidadeTotal)
                .locaisEstoque(estoqueLocalProdutoDtoList)
                .build();
    }

    @Override
    @Transactional
    public EstoqueProdutoDto movimentarProduto(MovimentacaoProdutoDto movimentacaoProduto) {
        ProdutoEntity produto = produtoService.findById(movimentacaoProduto.getProduto().getId())
                .orElseThrow(() -> new BusinessException("Produto não encontrado"));

        LocalEstoqueEntity localEstoque = localEstoqueService.findById((movimentacaoProduto.getLocalEstoque().getId()))
                .orElseThrow(() -> new BusinessException("Local Estoque não encontrado"));

        movimentarProduto(
                produto,
                localEstoque,
                movimentacaoProduto.getQuantidade(),
                movimentacaoProduto.getTipoMovimentacao()
        );

        return getEstoqueProduto(produto);
    }

    @Transactional
    public void movimentarProduto(
            ProdutoEntity produto,
            LocalEstoqueEntity localEstoque,
            BigDecimal quantidade,
            TipoMovimentacaoEstoque tipoMovimentacao
    ) {
        EstoqueProdutoEntity estoqueProduto = estoqueProdutoRepository.findEstoqueProduto(produto, localEstoque)
                .orElse(null);

        if (estoqueProduto == null) {
            if (tipoMovimentacao.isEntrada()) {
                estoqueProduto = estoqueProdutoRepository.save(new EstoqueProdutoEntity(produto, localEstoque));
            }
            else {
                throw new BusinessException("Esse Local não possui estoque do produto selecionado");
            }
        }

        movimentacaoEstoqueProdutoRepository.save(MovimentacaoEstoqueProdutoEntity.builder()
                .estoqueProduto(estoqueProduto)
                .quantidade(quantidade)
                .horarioMovimentacao(LocalDateTime.now())
                .tipoMovimentacaoEstoque(tipoMovimentacao)
                .build()
        );

        BigDecimal quantidadeMovimentada = tipoMovimentacao.isEntrada()
                ? quantidade
                : quantidade.negate();

        BigDecimal novaQuantidade = estoqueProduto.getQuantidadeEmEstoque().add(quantidadeMovimentada);

        if (novaQuantidade.compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException(
                    "Não foi possível movimentar o produto. Quantidade Atual: " + estoqueProduto.getQuantidadeEmEstoque()
            );
        }

        estoqueProduto.setQuantidadeEmEstoque(novaQuantidade);
        estoqueProdutoRepository.save(estoqueProduto);
    }

}
