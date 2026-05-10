package br.com.aquasoft.estoque.service.impl;

import br.com.aquasoft.estoque.entity.LocalEstoqueEntity;
import br.com.aquasoft.estoque.repository.LocalEstoqueRepository;
import br.com.aquasoft.estoque.service.ILocalEstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocalEstoqueService implements ILocalEstoqueService {

    private final LocalEstoqueRepository localEstoqueRepository;

    @Override
    public List<LocalEstoqueEntity> findAll() {
        return localEstoqueRepository.findAll();
    }

    @Override
    public Optional<LocalEstoqueEntity> findById(Long id) {
        return localEstoqueRepository.findById(id);
    }

    @Override
    public LocalEstoqueEntity save(LocalEstoqueEntity entity) {
        return localEstoqueRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        localEstoqueRepository.deleteById(id);
    }
}
