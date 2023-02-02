package com.dio.desafiospringboot.repository;

import com.dio.desafiospringboot.entity.Endereco;
import com.dio.desafiospringboot.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, String> {

}
