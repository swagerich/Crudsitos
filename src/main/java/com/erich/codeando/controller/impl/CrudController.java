package com.erich.codeando.controller.impl;

import com.erich.codeando.services.CRUDService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CrudController<T, S extends CRUDService<T>> {

    protected final S service;

    public CrudController(S service) {
        this.service = service;
    }

    //    @GetMapping("/pagination/{page}")
//    public ResponseEntity<?> findAllPage(@PathVariable Integer page) {
//        PageRequest pageRequest = PageRequest.of(page, 4);
//        return new ResponseEntity<>(service.findAllPage(pageRequest), HttpStatus.OK);
//    }


    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody T t) {
        return new ResponseEntity<>(service.save(t), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
