package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.TipoQuartoDTO;
import com.example.demo.entity.TipoQuarto;

@Component
public class TipoQuartoMapper {
    
    public TipoQuarto toEntity(TipoQuartoDTO dto) {  
        return TipoQuarto.builder()
            .nome(dto.nome())
            .descricao(dto.descricao())
            .capacidade(dto.capacidade())
            .valorDiaria(dto.valorDiaria())
            .build();
    }

    public TipoQuartoDTO toDto(TipoQuarto entity) {
        if (entity == null) return null;
        return new TipoQuartoDTO(
            entity.getId(),
            entity.getNome(),
            entity.getDescricao(),
            entity.getCapacidade(),
            entity.getValorDiaria()      
        );
    }

    public List<TipoQuartoDTO> toDtoList(List<TipoQuarto> entities) {
        if (entities == null) return null;

        return entities.stream()
            .map(this::toDto)
            .toList();
    }
}
