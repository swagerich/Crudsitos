package com.erich.codeando.controller;

import com.erich.codeando.controller.impl.CrudController;
import com.erich.codeando.dto.ContribuyenteDto;
import com.erich.codeando.entity.Contribuyente;
import com.erich.codeando.services.ContribuyenteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contribuyente")
public class ContribuyenteController extends CrudController<Contribuyente, ContribuyenteService> {

    public ContribuyenteController(ContribuyenteService service) {
        super(service);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Contribuyente contribuyente, @PathVariable Long id) {
        return new ResponseEntity<>(service.update(contribuyente, id), HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll()
                .stream()
                .map(ContribuyenteDto::fromEntity)
                .toList(),HttpStatus.OK);
    }
}
