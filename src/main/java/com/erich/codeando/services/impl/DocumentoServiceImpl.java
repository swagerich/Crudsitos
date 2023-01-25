package com.erich.codeando.services.impl;

import com.erich.codeando.entity.Documento;
import com.erich.codeando.exception.NotFoundException;
import com.erich.codeando.repository.DocumentRepository;
import com.erich.codeando.services.DocumentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentoServiceImpl extends CRUDServiceImpl<Documento, DocumentRepository> implements DocumentoService {

    public DocumentoServiceImpl(DocumentRepository repo) {
        super(repo);
    }

    @Override
    public Documento update(Documento documento, Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("NO EXISTE EL ID");
        }
        return repo.findById(id).map(d -> {
            d.setCode(documento.getCode());
            d.setCode(documento.getCode());
            d.setDescription(documento.getDescription());
            return repo.save(d);
        }).orElseThrow(() -> new NotFoundException("No se pudo actualizar"));
    }
}
