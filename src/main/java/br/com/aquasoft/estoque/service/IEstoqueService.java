package br.com.aquasoft.estoque.service;

import br.com.aquasoft.estoque.dto.MovimentacaoProdutoDto;
import br.com.aquasoft.estoque.dto.EstoqueProdutoDto;
import br.com.aquasoft.estoque.entity.ProdutoEntity;

public interface IEstoqueService {

    EstoqueProdutoDto getEstoqueProduto(String codigoProduto);

    EstoqueProdutoDto getEstoqueProduto(ProdutoEntity produto);

    EstoqueProdutoDto realizarMovimentacao(MovimentacaoProdutoDto entradaProduto);

}
