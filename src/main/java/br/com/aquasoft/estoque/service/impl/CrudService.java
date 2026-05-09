package br.com.aquasoft.estoque.service.impl;

import br.com.aquasoft.estoque.entity.BaseEntity;
import br.com.aquasoft.estoque.repository.BaseEntityRepository;
import br.com.aquasoft.estoque.service.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrudService<T extends BaseEntity> implements ICrudService<T> {

    private final BaseEntityRepository<T> baseEntityRepository;

    @Override
    public List<T> findAll() {
        return baseEntityRepository.findAll();
    }

    @Override
    public Optional<T> findById(Long id) {
        return baseEntityRepository.findById(id);
    }

    @Override
    public T save(T t) {
        return baseEntityRepository.save(t);
    }

    @Override
    public void deleteById(Long id) {
        baseEntityRepository.deleteById(id);
    }
}
