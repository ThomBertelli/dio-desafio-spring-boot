package com.dio.desafiospringboot.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Encomenda {

    @Id
    private String codigoRastreamento;

    private Integer peso;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destinatario_id")
    private Cliente destinatario;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private TipoEncomenda tipoEncomenda;

}
