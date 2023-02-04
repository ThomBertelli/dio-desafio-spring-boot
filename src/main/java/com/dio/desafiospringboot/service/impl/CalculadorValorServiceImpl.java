package com.dio.desafiospringboot.service.impl;

import com.dio.desafiospringboot.entity.Encomenda;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculadorValorServiceImpl {

    private Map<String, BigDecimal> tabelaTaxaEstado;

    public CalculadorValorServiceImpl(){
        tabelaTaxaEstado = new HashMap<>();

        tabelaTaxaEstado.put("SC", BigDecimal.valueOf(0.1));
        tabelaTaxaEstado.put("PR", BigDecimal.valueOf(0.1));
        tabelaTaxaEstado.put("RS", BigDecimal.valueOf(0.1));
        tabelaTaxaEstado.put("ES", BigDecimal.valueOf(0.2));
        tabelaTaxaEstado.put("MG", BigDecimal.valueOf(0.2));
        tabelaTaxaEstado.put("RJ", BigDecimal.valueOf(0.2));
        tabelaTaxaEstado.put("SP", BigDecimal.valueOf(0.2));
        tabelaTaxaEstado.put("DF", BigDecimal.valueOf(0.3));
        tabelaTaxaEstado.put("GO", BigDecimal.valueOf(0.3));
        tabelaTaxaEstado.put("MT", BigDecimal.valueOf(0.3));
        tabelaTaxaEstado.put("MS", BigDecimal.valueOf(0.3));
        tabelaTaxaEstado.put("AL", BigDecimal.valueOf(0.4));
        tabelaTaxaEstado.put("BA", BigDecimal.valueOf(0.4));
        tabelaTaxaEstado.put("CE", BigDecimal.valueOf(0.4));
        tabelaTaxaEstado.put("MA", BigDecimal.valueOf(0.4));
        tabelaTaxaEstado.put("PB", BigDecimal.valueOf(0.4));
        tabelaTaxaEstado.put("PE", BigDecimal.valueOf(0.4));
        tabelaTaxaEstado.put("PI", BigDecimal.valueOf(0.4));
        tabelaTaxaEstado.put("RN", BigDecimal.valueOf(0.4));
        tabelaTaxaEstado.put("SE", BigDecimal.valueOf(0.4));
        tabelaTaxaEstado.put("AC", BigDecimal.valueOf(0.5));
        tabelaTaxaEstado.put("AP", BigDecimal.valueOf(0.5));
        tabelaTaxaEstado.put("AM", BigDecimal.valueOf(0.5));
        tabelaTaxaEstado.put("PA", BigDecimal.valueOf(0.5));
        tabelaTaxaEstado.put("RO", BigDecimal.valueOf(0.5));
        tabelaTaxaEstado.put("RR", BigDecimal.valueOf(0.5));
        tabelaTaxaEstado.put("TO", BigDecimal.valueOf(0.5));

    }

    public BigDecimal calcularPreco(Integer peso, String estado, Enum TipoEncomenda){
        BigDecimal taxaEstado = tabelaTaxaEstado.get(estado);
        BigDecimal preco = BigDecimal.ZERO;

        if(TipoEncomenda.toString().equals("EXPRESSA")){
            preco = taxaEstado.multiply(BigDecimal.valueOf(peso)).multiply(BigDecimal.valueOf(0.3));
        }
        if(TipoEncomenda.toString().equals("STANDARD")){
            preco = taxaEstado.multiply(BigDecimal.valueOf(peso)).multiply(BigDecimal.valueOf(0.2));
        }
        if(TipoEncomenda.toString().equals("ECONOMICA")){
            preco = taxaEstado.multiply(BigDecimal.valueOf(peso)).multiply(BigDecimal.valueOf(0.1));
        }

        return preco;
    }


}
