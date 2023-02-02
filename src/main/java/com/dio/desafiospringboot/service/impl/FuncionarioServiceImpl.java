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
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por ID.
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }

}