package com.dio.desafiospringboot.service.impl;

import com.dio.desafiospringboot.entity.Cliente;
import com.dio.desafiospringboot.entity.Endereco;
import com.dio.desafiospringboot.entity.Funcionario;
import com.dio.desafiospringboot.repository.ClienteRepository;
import com.dio.desafiospringboot.repository.EnderecoRepository;
import com.dio.desafiospringboot.repository.FuncionarioRepository;
import com.dio.desafiospringboot.service.ClienteService;
import com.dio.desafiospringboot.service.FuncionarioService;
import com.dio.desafiospringboot.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;



    @Override
    public Iterable<Funcionario> buscarTodos() {
        // Buscar todos os Clientes.
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario buscarPorId(String matricula) {
        // Buscar Cliente por ID.
        Optional<Funcionario> funcionario = funcionarioRepository.findById(matricula);
        return funcionario.get();
    }

    @Override
    public void inserir(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    @Override
    public void atualizar(String matricula, Funcionario funcionario) {

        Optional<Funcionario> funcionadioBd = funcionarioRepository.findById(matricula);
        if (funcionadioBd.isPresent()) {
            funcionarioRepository.save(funcionario);
        }
    }

    @Override
    public void deletar(String matricula) {
        // Deletar Cliente por ID.
        funcionarioRepository.deleteById(matricula);
    }



}