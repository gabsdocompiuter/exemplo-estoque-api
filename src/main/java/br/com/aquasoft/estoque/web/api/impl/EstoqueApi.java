package br.com.aquasoft.estoque.web.api.impl;

import br.com.aquasoft.estoque.dto.EstoqueProdutoDto;
import br.com.aquasoft.estoque.service.IEstoqueService;
import br.com.aquasoft.estoque.web.api.IEstoqueApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class EstoqueApi implements IEstoqueApi {

    private final IEstoqueService estoqueService;

    @Override
    public ResponseEntity<EstoqueProdutoDto> getEstoqueProduto(String codigoProduto) {
        return ResponseEntity.ok(
                estoqueService.getEstoqueProduto(codigoProduto)
        );
    }
}
