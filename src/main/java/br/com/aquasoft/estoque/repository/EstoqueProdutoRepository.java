package br.com.aquasoft.estoque.repository;

import br.com.aquasoft.estoque.entity.EstoqueProdutoEntity;
import br.com.aquasoft.estoque.entity.LocalEstoqueEntity;
import br.com.aquasoft.estoque.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProdutoEntity, Long> {

    @Query("""
        SELECT ep
          FROM EstoqueProdutoEntity ep
         WHERE ep.produto = :produto
    """)
    List<EstoqueProdutoEntity> findEstoqueProduto(ProdutoEntity produto);

    @Query("""
        SELECT ep
          FROM EstoqueProdutoEntity ep
         WHERE ep.produto = :produto
           AND ep.localEstoque = :localEstoque
    """)
    Optional<EstoqueProdutoEntity> findEstoqueProduto(ProdutoEntity produto, LocalEstoqueEntity localEstoque);

}
