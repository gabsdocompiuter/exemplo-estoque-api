package br.com.aquasoft.estoque.web.api;

import br.com.aquasoft.estoque.dto.EstoqueProdutoDto;
import br.com.aquasoft.estoque.dto.MovimentacaoProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("estoque")
public interface IEstoqueApi {

    @GetMapping("/produto/{codigoProduto}")
    @Operation(summary = "Buscar o estoque de um produto")
    ResponseEntity<EstoqueProdutoDto> getEstoqueProduto(@PathVariable String codigoProduto);

    @PostMapping("/movimentar-estoque")
    @Operation(summary = "Realizar a movimentação de estoque de um produto")
    ResponseEntity<EstoqueProdutoDto> movimentarEstoque(@RequestBody MovimentacaoProdutoDto movimentacaoProduto);

}
