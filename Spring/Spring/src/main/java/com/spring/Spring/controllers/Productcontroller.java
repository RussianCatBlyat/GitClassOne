package com.spring.Spring.controllers;

import com.spring.Spring.dto.Productrecorddto;
import com.spring.Spring.models.Productmodel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produto")
public class Productcontroller {

    @Autowired
    com.spring.Spring.repository.Productrepository Productrepository;

    @PostMapping
    public ResponseEntity<Productmodel> saveproduct(@RequestBody @Valid Productrecorddto Productrecorddto) {
        var productmodel = new Productmodel();
        BeanUtils.copyProperties(Productrecorddto, productmodel);
        return ResponseEntity.status(HttpStatus.CREATED).body(Productrepository.save(productmodel));
    }

    @GetMapping
    public ResponseEntity<List<Productmodel>> getallproducts() {
        return ResponseEntity.status(HttpStatus.OK).body(Productrepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getoneproduct(@PathVariable(value = "id") int id) {
        Optional<Productmodel> product0 = Productrepository.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateproduct(@PathVariable(value = "id") int id, @RequestBody @Valid Productrecorddto Productrecorddto) {
        Optional<Productmodel> product0 = Productrepository.findAllById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto nao encontrado");
        }
        var Productmodel = product0.get();
        BeanUtils.copyProperties(Productrecorddto, Productmodel);
        return ResponseEntity.status(HttpStatus.OK).body(Productrepository.save(Productmodel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteproduct(@PathVariable(value = "id") int id) {
        Optional<Productmodel> product0 = Productrepository.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto nao encontrado");
        }
        Productrepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("produto excluido com sucesso");
    }

}
