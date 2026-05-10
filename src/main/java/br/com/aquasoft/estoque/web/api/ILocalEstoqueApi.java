package br.com.aquasoft.estoque.web.api;

import br.com.aquasoft.estoque.dto.LocalEstoqueDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("locais-estoque")
public interface ILocalEstoqueApi {

    @GetMapping
    @Operation(summary = "Listar todos os registros")
    ResponseEntity<List<LocalEstoqueDto>> findAll();

    @GetMapping("/{id}")
    @Operation(summary = "Listar um registro por id")
    ResponseEntity<LocalEstoqueDto> findById(@PathVariable Long id);

    @PostMapping
    @Operation(summary = "Salvar um novo registro")
    ResponseEntity<LocalEstoqueDto> save(@RequestBody LocalEstoqueDto localEstoque);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

}
