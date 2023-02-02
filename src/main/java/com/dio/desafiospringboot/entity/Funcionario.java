package com.dio.desafiospringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Funcionario {

    @Id
    private String matricula;
    private String nomeCompleto;
    private String senha;


}
