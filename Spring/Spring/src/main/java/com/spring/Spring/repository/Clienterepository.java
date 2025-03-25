package com.spring.Spring.repository;

import com.spring.Spring.models.Clientemodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface Clienterepository extends JpaRepository<Clientemodel, Integer>{
    Optional<Clientemodel> findById(int id);

    Optional<Clientemodel> findAllById(int id);
}
