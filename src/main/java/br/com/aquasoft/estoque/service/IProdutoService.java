package br.com.aquasoft.estoque.service;

import br.com.aquasoft.estoque.entity.ProdutoEntity;

import java.util.List;
import java.util.Optional;

public interface IProdutoService {

    List<ProdutoEntity> findAll();

    Optional<ProdutoEntity> findById(Long id);

    ProdutoEntity save(ProdutoEntity entity);

    void deleteById(Long id);
    
}
