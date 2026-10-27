package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.HospedeDTO;
import com.example.demo.entity.Hospede;

@Component
public class HospedeMapper {
    
    public Hospede toEntity(HospedeDTO dto) {
        return Hospede.builder()
            .cpf(dto.cpf())
            .nome(dto.nome())
            .idade(dto.idade())
            .build();

    }

    public HospedeDTO toDto(Hospede entity) {
        if (entity == null) return null;
        return new HospedeDTO(
            entity.getId(),
            entity.getNome(),
            entity.getIdade(),
            entity.getCpf()
        );
    }

    public List<HospedeDTO> toDtoList(List<Hospede> entities) {
        if (entities == null) return null;

        return entities.stream()
            .map(this::toDto)
            .toList();
    }

}
