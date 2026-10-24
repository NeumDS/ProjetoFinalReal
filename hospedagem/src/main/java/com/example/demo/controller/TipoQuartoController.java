package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(service.cadastrar(requestDto));
    }

    @GetMapping("/teste")
    public String teste() {
    return "Controller funcionando!";
}

}
