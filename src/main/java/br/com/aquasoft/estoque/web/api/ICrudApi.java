package br.com.aquasoft.estoque.web.api;

import br.com.aquasoft.estoque.entity.BaseEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

public interface ICrudApi<T extends BaseEntity> {

    @GetMapping
    @Operation(summary = "Listar todos os registros")
    ResponseEntity<List<T>> findAll();

    @GetMapping("/{id}")
    @Operation(summary = "Listar um registro por id")
    ResponseEntity<Optional<T>> findById(@PathVariable Long id);

    @PostMapping
    @Operation(summary = "Salvar um novo registro")
    ResponseEntity<T> save(T t);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
