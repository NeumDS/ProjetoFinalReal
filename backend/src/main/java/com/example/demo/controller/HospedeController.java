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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HospedeDTO;
import com.example.demo.service.HospedeService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/hospede")
@RequiredArgsConstructor 
public class HospedeController {
    
    private final HospedeService service;

    @GetMapping 
    public ResponseEntity<List<HospedeDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping 
    public ResponseEntity<HospedeDTO> cadastrar(
        @RequestBody HospedeDTO requestDto) {
            
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.cadastrar(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospedeDTO> buscarPorId(
        @PathVariable Long id) {

            return ResponseEntity.ok(service.buscarPorId(id));

    }

    @GetMapping("/buscar")
    public ResponseEntity<List<HospedeDTO>> buscarPorNome(
       @RequestParam String nome) {

            return ResponseEntity.ok(service.buscarPorNome(nome));
    
        
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<HospedeDTO> atualizar(
        @PathVariable Long id,
        @RequestBody HospedeDTO requestDto) {

            return ResponseEntity.ok(service.atualizar(id, requestDto));

    }
}
