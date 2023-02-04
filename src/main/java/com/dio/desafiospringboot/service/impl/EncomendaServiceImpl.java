package com.dio.desafiospringboot.service.impl;

import com.dio.desafiospringboot.entity.Encomenda;
import com.dio.desafiospringboot.repository.EncomendaRepository;
import com.dio.desafiospringboot.service.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class EncomendaServiceImpl implements EncomendaService {

    @Autowired
    private EncomendaRepository encomendaRepository;
    @Autowired
    private TrackingService trackingService;
    @Autowired
    private CalculadorValorServiceImpl calculadorValorService;

    @Autowired
    private ClienteServiceImpl clienteService;



    public void inserir(Encomenda encomenda) {
        clienteService.inserir(encomenda.getDestinatario());

        encomenda.setCodigoRastreamento(trackingService.generateTrackingCode());
        encomenda.setPreco(calculadorValorService.calcularPreco(encomenda.getPeso(), encomenda.getDestinatario().getEndereco().getUf(),encomenda.getTipoEncomenda()));
        encomendaRepository.save(encomenda);
    }

    public Optional<Encomenda> buscarPorId(String codigoRastreamento) {
        return encomendaRepository.findById(codigoRastreamento);
    }
}

@Service
class TrackingService {
    private static final int LENGTH = 13;
    private static final int CHAR_RANGE = 26;
    private static final int ASCII_OFFSET = 65;
    private static final String TRACKING_CODE_SUFFIX = "BR";

    private Random random;

    public TrackingService() {
        random = new Random();
    }

    public String generateTrackingCode() {
        StringBuilder trackingCode = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            trackingCode.append((char) (random.nextInt(CHAR_RANGE) + ASCII_OFFSET));
        }
        for (int i = 0; i < LENGTH - TRACKING_CODE_SUFFIX.length() - 2; i++) {
            trackingCode.append(random.nextInt(10));
        }
        trackingCode.append(TRACKING_CODE_SUFFIX);
        return trackingCode.toString();
    }



}
