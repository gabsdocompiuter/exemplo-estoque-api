package br.com.aquasoft.estoque.repository;

import br.com.aquasoft.estoque.entity.MovimentacaoEstoqueProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoEstoqueProdutoRepository extends JpaRepository<MovimentacaoEstoqueProdutoEntity, Long> {

}
