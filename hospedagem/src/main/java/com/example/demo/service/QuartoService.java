package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.QuartoDTO;
import com.example.demo.entity.Quarto;
import com.example.demo.entity.TipoQuarto;
import com.example.demo.mapper.QuartoMapper;
import com.example.demo.repository.QuartoRepository;
import com.example.demo.repository.TipoQuartoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuartoService {
    
    private final QuartoMapper mapper;
    private final QuartoRepository repository;
    private final TipoQuartoRepository repository2;

    public List<QuartoDTO> listar() {
        return mapper.toDtoList(repository.findAll());
    }

    @Transactional
    public QuartoDTO cadastrar(QuartoDTO requestDto) {

        TipoQuarto tipoQuarto = repository2
            .findById(requestDto.tipoQuartoID())
            .orElseThrow(() -> new RuntimeException("Tipo de quarto não encontrado"));

        Quarto cadastro = mapper.toEntity(requestDto, tipoQuarto);

        Quarto cadastroSalvo = repository.save(cadastro);

        return mapper.toDto(cadastroSalvo);
    }

    public QuartoDTO buscarPorId(Long id) {
        Quarto quarto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        return mapper.toDto(quarto);

    }

    @Transactional
    public QuartoDTO atualizar(Long id, QuartoDTO requestDTO, TipoQuarto tipoQuarto) {
        Quarto quarto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        quarto.setNumero(requestDTO.numero());
        quarto.setTipoQuarto(tipoQuarto);
        quarto.setStatus(requestDTO.status());

        Quarto quartoAtualizado = repository.save(quarto);

        return mapper.toDto(quartoAtualizado);

    }

    @Transactional
    public void excluir(Long id) {
        Quarto quarto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));
        
        quarto.setAtivo(false);

        repository.save(quarto);
    }

    public void reativar(Long id) {
        Quarto quarto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));
        
            quarto.setAtivo(true);

            repository.save(quarto);
    }
}
