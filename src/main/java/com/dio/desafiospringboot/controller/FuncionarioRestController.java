package com.dio.desafiospringboot.controller;

import com.dio.desafiospringboot.entity.Funcionario;
import com.dio.desafiospringboot.service.FuncionarioService;
import com.dio.desafiospringboot.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioRestController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<Iterable<Funcionario>> buscarTodos() {
        return ResponseEntity.ok(funcionarioService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable String matricula) {
        return ResponseEntity.ok(funcionarioService.buscarPorId(matricula));
    }

    @PostMapping
    public ResponseEntity<Funcionario> inserir(@RequestBody Funcionario funcionario) {
        funcionarioService.inserir(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable String matricula, @RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(matricula, funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String matricula) {
        funcionarioService.deletar(matricula);
        return ResponseEntity.ok().build();
    }
}
