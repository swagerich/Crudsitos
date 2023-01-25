package com.erich.codeando.repository;

import com.erich.codeando.entity.Documento;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository  extends CrudRepository<Documento,Long> {


}
