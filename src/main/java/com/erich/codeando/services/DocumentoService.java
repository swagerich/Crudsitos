package com.erich.codeando.services;

import com.erich.codeando.entity.Documento;

public interface DocumentoService extends CRUDService<Documento>{

    Documento update(Documento documento,Long id);
}
