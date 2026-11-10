package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReservaServicoDTO;
import com.example.demo.service.ReseervaServicoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reserva-servicos")
@RequiredArgsConstructor
public class ReservaServicoController {
    
    private final ReseervaServicoService service;

    @GetMapping
    public ResponseEntity<List<ReservaServicoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<ReservaServicoDTO> cadastrar(
        @RequestBody ReservaServicoDTO requestDto) {

            return ResponseEntity	
                .status(HttpStatus.CREATED)
                .body(service.cadastrar(requestDto));
        }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaServicoDTO> atualizar (
        @PathVariable Long id,
        @RequestBody ReservaServicoDTO requestDto) {

            return ResponseEntity.ok(service.atualizar(id, requestDto));

        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}/reativar")
    public ResponseEntity<Void> reativar(
        @PathVariable Long id) {

            service.reativar(id);

            return ResponseEntity.noContent().build();

        }
    
    
    
    
}
