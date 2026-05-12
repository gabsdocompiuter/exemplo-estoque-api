package br.com.aquasoft.estoque.service.impl;

import br.com.aquasoft.estoque.dto.EstoqueLocalProdutoDto;
import br.com.aquasoft.estoque.dto.EstoqueProdutoDto;
import br.com.aquasoft.estoque.dto.ProdutoDto;
import br.com.aquasoft.estoque.entity.EstoqueProdutoEntity;
import br.com.aquasoft.estoque.entity.ProdutoEntity;
import br.com.aquasoft.estoque.repository.EstoqueProdutoRepository;
import br.com.aquasoft.estoque.repository.MovimentacaoEstoqueProdutoRepository;
import br.com.aquasoft.estoque.service.IEstoqueService;
import br.com.aquasoft.estoque.service.IProdutoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstoqueService implements IEstoqueService {

    private final IProdutoService produtoService;

    private final EstoqueProdutoRepository estoqueProdutoRepository;
    private final MovimentacaoEstoqueProdutoRepository movimentacaoEstoqueProdutoRepository;

    @Override
    public EstoqueProdutoDto getEstoqueProduto(String codigoProduto) {
        ProdutoEntity produto = produtoService.findByCodigoBarras(codigoProduto)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado: " + codigoProduto));

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
}
