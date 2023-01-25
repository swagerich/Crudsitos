package com.erich.codeando.services.impl;

import com.erich.codeando.entity.Entidad;
import com.erich.codeando.exception.NotFoundException;
import com.erich.codeando.repository.EntidadRepository;
import com.erich.codeando.services.EntidadService;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class EntidadServiceImpl extends CRUDServiceImpl<Entidad, EntidadRepository> implements EntidadService {

    public EntidadServiceImpl(EntidadRepository repo) {
        super(repo);
    }

    @Override
    public Entidad update(Entidad update, Long id) {
        return null;
    }

    @Override
    public List<Entidad> findByContribuyenteId(Long id) {
        return repo.findByContribuyenteId(id);
    }

    @Override
    public List<Entidad> findByDocumentId(Long id) {
        return repo.findByDocumentId(id);
    }

}
