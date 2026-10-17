package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.QuartoDTO;
import com.example.demo.entity.Quarto;
import com.example.demo.entity.TipoQuarto;

@Component
public class QuartoMapper {
    
    public Quarto toEntity(QuartoDTO dto, TipoQuarto tipoQuarto){
        return Quarto.builder()
            .numero(dto.numero())
            .tipoQuarto(tipoQuarto)
            .status(dto.status())
            .build();
    }

    public QuartoDTO toDto(Quarto entity){
        if (entity == null) return null;
        return new QuartoDTO(
            entity.getId(),
            entity.getNumero(),
            entity.getTipoQuarto().getId(),
            entity.getStatus()
        );
    }

    public List<QuartoDTO> toDtoList(List<Quarto> entities){
        if (entities == null) return null;

        return entities.stream()
            .map(this::toDto)
            .toList();
    }

}
