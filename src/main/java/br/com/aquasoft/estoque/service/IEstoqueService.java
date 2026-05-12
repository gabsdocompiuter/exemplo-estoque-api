package br.com.aquasoft.estoque.service;

import br.com.aquasoft.estoque.dto.EstoqueProdutoDto;

public interface IEstoqueService {

    EstoqueProdutoDto getEstoqueProduto(String codigoProduto);

}
