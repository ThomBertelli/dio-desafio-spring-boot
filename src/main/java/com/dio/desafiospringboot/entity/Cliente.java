package com.dio.desafiospringboot.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nomeCompleto;

    @ManyToOne
    private Endereco endereco;

    private String cep;


}
