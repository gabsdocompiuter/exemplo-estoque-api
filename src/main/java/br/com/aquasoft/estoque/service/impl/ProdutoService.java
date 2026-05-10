package br.com.aquasoft.estoque.service.impl;

import br.com.aquasoft.estoque.entity.ProdutoEntity;
import br.com.aquasoft.estoque.repository.ProdutoRepository;
import br.com.aquasoft.estoque.service.IProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService implements IProdutoService {

    private final ProdutoRepository produtoRepository;


    @Override
    public List<ProdutoEntity> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<ProdutoEntity> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public ProdutoEntity save(ProdutoEntity entity) {
        return produtoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}
