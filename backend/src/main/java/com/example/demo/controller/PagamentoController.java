package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PagamentoDTO;
import com.example.demo.service.PagamentoService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("pagamentos")
@RequiredArgsConstructor 
public class PagamentoController {
    
    private final PagamentoService service;

    @GetMapping 
    public ResponseEntity<List<PagamentoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping 
    public ResponseEntity<PagamentoDTO> cadastrar(
        @RequestBody PagamentoDTO requestDto) {

            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.cadastrar(requestDto));        
        }
        
    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> buscarPorId(
        @PathVariable Long id) {

            return ResponseEntity.ok(service.buscarPorId(id));
        }
    

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDTO> atualizar(
        @PathVariable Long id,
        @RequestBody PagamentoDTO requestDto) {

            return ResponseEntity.ok(service.atualizar(id, requestDto));
        }
    

}
