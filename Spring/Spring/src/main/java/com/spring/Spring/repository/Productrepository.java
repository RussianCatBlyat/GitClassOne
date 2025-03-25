package com.spring.Spring.repository;

import com.spring.Spring.models.Productmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Productrepository extends JpaRepository<Productmodel, Integer>{
    Optional<Productmodel> findById(int id);

    Optional<Productmodel> findAllById(int id);
}
