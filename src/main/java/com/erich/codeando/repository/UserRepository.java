package com.erich.codeando.repository;

import com.erich.codeando.entity.Username;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Username, Long> {

    Optional<Username> findByEmailContaining(String email);
}
