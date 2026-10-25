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

import com.example.demo.dto.QuartoDTO;
import com.example.demo.service.QuartoService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/quarto")
@RequiredArgsConstructor 
public class QuartoController {
    
    private final QuartoService service;

    @GetMapping 
    public ResponseEntity<List<QuartoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping 
    public ResponseEntity<QuartoDTO> cadastrar( 
        @RequestBody QuartoDTO requestDto) {

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.cadastrar(requestDto));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<QuartoDTO> buscarPorID(
        @PathVariable Long id) {
            
            return ResponseEntity.ok(service.buscarPorId(id));
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoDTO> atualizar(
        @PathVariable Long id,
        @RequestBody QuartoDTO requesDto) {

        return  ResponseEntity.ok(service.atualizar(id, requesDto, null));  
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
