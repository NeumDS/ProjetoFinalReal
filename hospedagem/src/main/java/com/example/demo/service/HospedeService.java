package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HospedeDTO;
import com.example.demo.entity.Hospede;
import com.example.demo.mapper.HospedeMapper;
import com.example.demo.repository.HospedeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class HospedeService {
    
    private final HospedeMapper mapper;
    private final HospedeRepository repository;

    public List<HospedeDTO> listar() {
        return mapper.toDtoList(repository.findAll());
    }

    @Transactional 
    public HospedeDTO cadastrar(HospedeDTO requestDto) {
        Hospede cadastro = mapper.toEntity(requestDto);

        Hospede cadastroSalvo = repository.save(cadastro);

        return mapper.toDto(cadastroSalvo);
    }

    public HospedeDTO buscarPorId(Long id) {
        Hospede hospede = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Hospede não encontrado"));
        
        return mapper.toDto(hospede);
    }

    public List<HospedeDTO> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
            .stream()
            .map(mapper::toDto)
            .toList();
    }   

    @Transactional 
    public HospedeDTO atualizar(Long id, HospedeDTO requestDto) {
        Hospede hospede = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Hospede não encontrado"));
        
        hospede.setNome(requestDto.nome());
        hospede.setCpf(requestDto.cpf());
        hospede.setIdade(requestDto.idade());

        Hospede hospedeAtualizado = repository.save(hospede);

        return mapper.toDto(hospedeAtualizado);

    }
}
