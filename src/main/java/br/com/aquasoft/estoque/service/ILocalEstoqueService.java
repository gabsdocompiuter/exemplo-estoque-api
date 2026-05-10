package br.com.aquasoft.estoque.service;

import br.com.aquasoft.estoque.entity.LocalEstoqueEntity;

import java.util.List;
import java.util.Optional;

public interface ILocalEstoqueService {

    List<LocalEstoqueEntity> findAll();

    Optional<LocalEstoqueEntity> findById(Long id);

    LocalEstoqueEntity save(LocalEstoqueEntity entity);

    void deleteById(Long id);

}
