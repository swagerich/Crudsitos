package com.erich.codeando.services.impl;

import com.erich.codeando.services.CRUDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Slf4j
public class CRUDServiceImpl<T, R extends CrudRepository<T, Long>> implements CRUDService<T> {

    protected final R repo;

    public CRUDServiceImpl(R repo) {
        this.repo = repo;
    }

    @Override
    public T save(T t) {
        return repo.save(t);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) repo.findAll();
    }

    @Override
    public T findById(Long id) {
        if (id == null) {
            log.error("ID vino null");
            return null;
        }
        return repo.findById(id).orElseThrow(() -> new RuntimeException("ocurrio algo"));
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            log.error("ID vino NUll");
            return;
        }
        repo.deleteById(id);
    }
}
