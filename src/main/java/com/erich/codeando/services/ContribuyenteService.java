package com.erich.codeando.services;

import com.erich.codeando.entity.Contribuyente;

public interface ContribuyenteService extends CRUDService<Contribuyente> {

    Contribuyente update(Contribuyente contribuyente, Long id);



}
