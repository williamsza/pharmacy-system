package com.remedios.curso.controllers;

import java.util.List;

import com.remedios.curso.remedio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados, UriComponentsBuilder uriBuilder) {
        var remedio = new Remedio(dados);
        repository.save(remedio);
        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));
    }


//    @GetMapping
//    private ResponseEntity<List<DadosListagemRemedio>> listar() {
//        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
//        return ResponseEntity.ok(lista);
//    }

    @GetMapping
    public List<DadosListagemRemedio> listar() {
        return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
    }


    @Transactional
    @PutMapping
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);

            return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable long id) {
        var remedio = repository.getReferenceById(id);
        remedio.inativar();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Valid> reativar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.reativar();
        return ResponseEntity.noContent().build();


    }
    @GetMapping("/{id}")

    public ResponseEntity<DadosDetalhamentoRemedio> detalhar(@PathVariable long id) {
        var remedio = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

}


