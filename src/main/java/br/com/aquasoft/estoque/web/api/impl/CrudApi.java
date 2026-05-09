package br.com.aquasoft.estoque.web.api.impl;

import br.com.aquasoft.estoque.entity.BaseEntity;
import br.com.aquasoft.estoque.service.impl.CrudService;
import br.com.aquasoft.estoque.web.api.ICrudApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public class CrudApi<T extends BaseEntity> implements ICrudApi<T> {

    @Autowired
    private CrudService<T> crudService;

    @Override
    public ResponseEntity<List<T>> findAll() {
        return ResponseEntity.ok(
                crudService.findAll()
        );
    }

    @Override
    public ResponseEntity<Optional<T>> findById(Long id) {
        return ResponseEntity.ofNullable(
                crudService.findById(id)
        );
    }

    @Override
    public ResponseEntity<T> save(T t) {
        return ResponseEntity.ok(
                crudService.save(t)
        );
    }

    @Override
    public void delete(Long id) {
        crudService.deleteById(id);
    }
}
