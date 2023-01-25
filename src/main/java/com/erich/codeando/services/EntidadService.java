package com.erich.codeando.services;

import com.erich.codeando.entity.Entidad;

import java.util.List;

public interface EntidadService extends CRUDService<Entidad> {

    Entidad update(Entidad update,Long id);

    List<Entidad> findByContribuyenteId(Long id);

    List<Entidad> findByDocumentId(Long id);

}
