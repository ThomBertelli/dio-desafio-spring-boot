package com.dio.desafiospringboot.service;

import com.dio.desafiospringboot.entity.Funcionario;

public interface FuncionarioService {

    Iterable<Funcionario> buscarTodos();

    Funcionario buscarPorId(String id);

    void inserir(Funcionario funcionario);

    void atualizar(String matricula, Funcionario funcionario);

    void deletar(String matricula);


}
