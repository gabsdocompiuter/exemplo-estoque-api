package br.com.aquasoft.estoque.web.api;

import br.com.aquasoft.estoque.dto.EstoqueProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("estoque")
public interface IEstoqueApi {

    @GetMapping("/produto/{codigoProduto}")
    @Operation(summary = "Buscar o estoque de um produto")
    ResponseEntity<EstoqueProdutoDto> getEstoqueProduto(@PathVariable String codigoProduto);

}
