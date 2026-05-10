package br.com.aquasoft.estoque.web.api;

import br.com.aquasoft.estoque.dto.ProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("produtos")
public interface IProdutoApi {

    @GetMapping
    @Operation(summary = "Listar todos os registros")
    ResponseEntity<List<ProdutoDto>> findAll();

    @GetMapping("/{id}")
    @Operation(summary = "Listar um registro por id")
    ResponseEntity<ProdutoDto> findById(@PathVariable Long id);

    @PostMapping
    @Operation(summary = "Salvar um novo registro")
    ResponseEntity<ProdutoDto> save(@RequestBody ProdutoDto localEstoque);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

}
