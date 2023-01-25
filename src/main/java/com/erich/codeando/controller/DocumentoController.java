package com.erich.codeando.controller;


import com.erich.codeando.controller.impl.CrudController;
import com.erich.codeando.entity.Documento;

import com.erich.codeando.services.DocumentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController extends CrudController<Documento, DocumentoService> {

    public DocumentoController(DocumentoService service) {
        super(service);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Documento documento, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(documento, id), HttpStatus.CREATED);
    }
}
