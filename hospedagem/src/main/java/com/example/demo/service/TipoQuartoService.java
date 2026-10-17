package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.TipoQuartoDTO;
import com.example.demo.entity.TipoQuarto;
import com.example.demo.mapper.TipoQuartoMapper;
import com.example.demo.repository.TipoQuartoRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoQuartoService {

    private final TipoQuartoMapper mapper;
    private final TipoQuartoRepository repository;

    public List<TipoQuartoDTO> listar() {
        return mapper.toDtoList(repository.findAll());
    }

    @Transactional
    public TipoQuartoDTO cadastrar(TipoQuartoDTO requesDto) {
        TipoQuarto cadastro = mapper.toEntity(requesDto);

        TipoQuarto cadastroSalvo = repository.save(cadastro);

        return mapper.toDto(cadastroSalvo);
}
    
    
}
