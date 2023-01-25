package com.erich.codeando.services;

import java.util.List;

public interface CRUDService<T> {

    T save(T t);

    List<T> findAll();

    T findById(Long id);

    void deleteById(Long id);

}
