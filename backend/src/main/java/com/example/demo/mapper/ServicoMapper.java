package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ServicoDTO;
import com.example.demo.entity.Servico;

@Component 
public class ServicoMapper {
    
    public Servico toEntity(ServicoDTO dto) {
        return Servico.builder()
            .nome(dto.nome())
            .descricao(dto.descricao())
            .valorServico(dto.valorServico())
            .ativo(true)
            .build();
    }

    public ServicoDTO toDto(Servico entity) {
        if (entity == null) return null;
        return new ServicoDTO(
            entity.getId(),
            entity.getNome(),
            entity.getDescricao(),
            entity.getValorServico()
        );
    }

    public List<ServicoDTO> toDtoList(List<Servico> entities) {
        if (entities == null) return null;

        return entities.stream()
            .map(this::toDto)
            .toList();
    }
}
