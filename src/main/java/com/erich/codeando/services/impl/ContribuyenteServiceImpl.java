package com.erich.codeando.services.impl;

import com.erich.codeando.entity.Contribuyente;
import com.erich.codeando.exception.NotFoundException;
import com.erich.codeando.repository.ContribuyenteRepository;
import com.erich.codeando.services.ContribuyenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ContribuyenteServiceImpl extends CRUDServiceImpl<Contribuyente, ContribuyenteRepository> implements ContribuyenteService {

    public ContribuyenteServiceImpl(ContribuyenteRepository repo) {
        super(repo);
    }

    @Override
    public Contribuyente update(Contribuyente contribuyente, Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("NO EXISTE EL ID");
        }
        return repo.findById(id).map(c -> {
            c.setName(contribuyente.getName());
            c.setState(contribuyente.isState());
            return repo.save(c);
        }).orElseThrow(() -> new NotFoundException("id no encontrado" + id));
    }

}
