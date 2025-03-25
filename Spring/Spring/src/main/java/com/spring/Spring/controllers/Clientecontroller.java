package com.spring.Spring.controllers;

import com.spring.Spring.dto.Clienterecorddto;
import com.spring.Spring.models.Clientemodel;
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
@RequestMapping("/cliente")
public class Clientecontroller {

    @Autowired
    com.spring.Spring.repository.Clienterepository Clienterepository;

    @PostMapping
    public ResponseEntity<Clientemodel> savecliente(@RequestBody @Valid Clienterecorddto Clienterecorddto) {
        var clientemodel = new Clientemodel();
        BeanUtils.copyProperties(Clienterecorddto, clientemodel);
        return ResponseEntity.status(HttpStatus.CREATED).body(Clienterepository.save(clientemodel));
    }

    @GetMapping
    public ResponseEntity<List<Clientemodel>> getallclientes() {
        return ResponseEntity.status(HttpStatus.OK).body(Clienterepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getonecliente(@PathVariable(value = "id") int id) {
        Optional<Clientemodel> cliente0 = Clienterepository.findById(id);
        if (cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente nao encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente0.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatecliente(@PathVariable(value = "id") int id, @RequestBody @Valid Clienterecorddto Clienterecorddto) {
        Optional<Clientemodel> cliente0 = Clienterepository.findAllById(id);
        if (cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente nao encontrado");
        }
        var Clientemodel = cliente0.get();
        BeanUtils.copyProperties(Clienterecorddto, Clientemodel);
        return ResponseEntity.status(HttpStatus.OK).body(Clienterepository.save(Clientemodel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletecliente(@PathVariable(value = "id") int id) {
        Optional<Clientemodel> cliente0 = Clienterepository.findById(id);
        if (cliente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente nao encontrado");
        }
        Clienterepository.delete(cliente0.get());
        return ResponseEntity.status(HttpStatus.OK).body("cliente excluido com sucesso");
    }

}
