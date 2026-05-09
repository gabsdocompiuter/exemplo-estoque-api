package br.com.aquasoft.estoque.service;

import br.com.aquasoft.estoque.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T extends BaseEntity> {

    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void deleteById(Long id);

}
