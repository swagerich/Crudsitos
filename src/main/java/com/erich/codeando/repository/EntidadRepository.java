package com.erich.codeando.repository;

import com.erich.codeando.entity.Entidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntidadRepository extends CrudRepository<Entidad, Long> {

    @Query("SELECT e from Entidad e INNER JOIN FETCH e.contribuyente c WHERE c.id=?1")
    List<Entidad> findByContribuyenteId(Long id);

    List<Entidad> findByDocumentId(Long id);
}
