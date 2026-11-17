package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ReservaServicoDTO;
import com.example.demo.entity.Reserva;
import com.example.demo.entity.ReservaServico;
import com.example.demo.entity.Servico;

@Component
public class ReservaServicoMapper {
    
    public ReservaServico toEntity(ReservaServicoDTO dto,
         Servico servico,
         Reserva reserva) {
        return ReservaServico.builder()
            .servico(servico)
            .reserva(reserva)
            .quantidade(dto.quantidade())
            .valorUnitario(dto.valorUnitario())
            .build();

         }

    public ReservaServicoDTO toDto(ReservaServico entity) {
        if (entity == null) return null;
        return new ReservaServicoDTO(
            entity.getId(),
            entity.getServico().getId(),
            entity.getReserva().getId(),
            entity.getQuantidade(),
            entity.getValorUnitario()
        );
    }

    public List<ReservaServicoDTO> toDtoList(List<ReservaServico> entities) {
        if (entities == null) return null;
        return entities.stream()
            .map(this::toDto)
            .toList();

    }

}
