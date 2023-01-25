package com.erich.codeando.controller;

import com.erich.codeando.controller.impl.CrudController;
import com.erich.codeando.entity.Entidad;
import com.erich.codeando.services.EntidadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/entidad")
public class EntidadController extends CrudController<Entidad, EntidadService> {

    public EntidadController(EntidadService service) {
        super(service);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Entidad entidad, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(entidad, id), HttpStatus.CREATED);
    }

    @GetMapping("/contribuyente/{id}")
    public ResponseEntity<?> findByContribuyente(@PathVariable Long id) {
        return new ResponseEntity<>(service.findByContribuyenteId(id), HttpStatus.OK);
    }

    @GetMapping("/documento/{id}")
    public ResponseEntity<?> findByDocumentId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findByDocumentId(id), HttpStatus.OK);
    }

}
