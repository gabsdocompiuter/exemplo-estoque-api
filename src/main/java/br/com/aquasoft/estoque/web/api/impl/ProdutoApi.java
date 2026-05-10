package br.com.aquasoft.estoque.web.api.impl;

import br.com.aquasoft.estoque.dto.ProdutoDto;
import br.com.aquasoft.estoque.service.IProdutoService;
import br.com.aquasoft.estoque.web.api.IProdutoApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProdutoApi implements IProdutoApi {

    private final IProdutoService produtoService;

    @Override
    public ResponseEntity<List<ProdutoDto>> findAll() {
        return ResponseEntity.ok(
                ProdutoDto.fromEntity(produtoService.findAll())
        );
    }

    @Override
    public ResponseEntity<ProdutoDto> findById(Long id) {
        return produtoService.findById(id)
                .map(ProdutoDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @Override
    public ResponseEntity<ProdutoDto> save(ProdutoDto produto) {
        return ResponseEntity.ok(
                ProdutoDto.fromEntity(produtoService.save(produto.toEntity()))
        );
    }

    @Override
    public void delete(Long id) {
        produtoService.deleteById(id);
    }

}
