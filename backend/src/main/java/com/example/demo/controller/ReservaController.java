package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ReservaDTO;
import com.example.demo.service.ReservaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> listar() {
        return ResponseEntity.ok(reservaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> criar(@RequestBody ReservaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservaService.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> atualizar(
            @PathVariable Long id,
            @RequestBody ReservaDTO dto) {
        return ResponseEntity.ok(reservaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        reservaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}