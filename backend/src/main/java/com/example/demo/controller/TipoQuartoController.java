
package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TipoQuartoDTO;
import com.example.demo.service.TipoQuartoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tipos-quarto")
@RequiredArgsConstructor
public class TipoQuartoController {

    private final TipoQuartoService service;

    @GetMapping
    public ResponseEntity<List<TipoQuartoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<TipoQuartoDTO> cadastrar(
            @RequestBody TipoQuartoDTO requestDto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.cadastrar(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoQuartoDTO> buscarPorID(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorID(id));
    }

    @PutMapping("/{id}") 
    public ResponseEntity<TipoQuartoDTO> atualizar(
            @PathVariable Long id,
            @RequestBody TipoQuartoDTO requestDto) {

        return ResponseEntity.ok(service.atualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/reativar") 
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        
        service.reativar(id);
        
        return ResponseEntity.noContent().build();
    }

}
