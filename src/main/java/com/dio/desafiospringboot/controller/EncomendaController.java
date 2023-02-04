package com.dio.desafiospringboot.controller;

import com.dio.desafiospringboot.entity.Encomenda;
import com.dio.desafiospringboot.service.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("encomendas")
public class EncomendaController {

    @Autowired
    private EncomendaService encomendaService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Encomenda>> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(encomendaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Encomenda> inserir(@RequestBody Encomenda encomenda) {
        encomendaService.inserir(encomenda);
        return ResponseEntity.ok(encomenda);
    }


}
