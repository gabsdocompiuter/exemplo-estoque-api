package br.com.aquasoft.estoque.web.api.impl;

import br.com.aquasoft.estoque.dto.LocalEstoqueDto;
import br.com.aquasoft.estoque.entity.LocalEstoqueEntity;
import br.com.aquasoft.estoque.service.ILocalEstoqueService;
import br.com.aquasoft.estoque.web.api.ILocalEstoqueApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
class LocalEstoqueApi implements ILocalEstoqueApi {

    private final ILocalEstoqueService localEstoqueService;

    @Override
    public ResponseEntity<List<LocalEstoqueDto>> findAll() {
        return ResponseEntity.ok(
                LocalEstoqueDto.fromEntity(localEstoqueService.findAll())
        );
    }

    @Override
    public ResponseEntity<LocalEstoqueDto> findById(Long id) {
        Optional<LocalEstoqueEntity> result = localEstoqueService.findById(id);

        return result.map(LocalEstoqueDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @Override
    public ResponseEntity<LocalEstoqueDto> save(LocalEstoqueDto localEstoqueDto) {
        return ResponseEntity.ok(
                LocalEstoqueDto.fromEntity(localEstoqueService.save(localEstoqueDto.toEntity()))
        );
    }

    @Override
    public void delete(Long id) {
        localEstoqueService.deleteById(id);
    }

}
