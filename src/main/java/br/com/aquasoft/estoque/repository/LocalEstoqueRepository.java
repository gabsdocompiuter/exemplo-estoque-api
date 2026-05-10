package br.com.aquasoft.estoque.repository;

import br.com.aquasoft.estoque.entity.LocalEstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalEstoqueRepository extends JpaRepository<LocalEstoqueEntity, Long> {

}
