package com.dio.desafiospringboot.service;

import com.dio.desafiospringboot.entity.Encomenda;

import java.util.Optional;

public interface EncomendaService {

    void inserir(Encomenda encomenda);
    Optional<Encomenda> buscarPorId(String id);
}
