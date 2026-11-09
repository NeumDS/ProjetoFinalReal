package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ReservaDTO;
import com.example.demo.entity.Reserva;
import com.example.demo.entity.Quarto;
import com.example.demo.entity.Hospede;

@Component
public class ReservaMapper {

    public Reserva toEntity(ReservaDTO dto, Quarto quarto, Hospede hospede) {
        return Reserva.builder()
                .id(dto.id())
                .quarto(quarto)
                .hospede(hospede)
                .pagamentos(null)
                .servicos(null)
                .valorDiaria(dto.valorDiaria())
                .diasTotais(dto.diasTotais())
                .build();
    }

    public ReservaDTO toDto(Reserva reserva) {
        
        return new ReservaDTO(
                reserva.getId(),
                reserva.getQuarto().getId(),
                reserva.getHospede().getId(),
                null,
                null,
                reserva.getValorDiaria(),
                reserva.getDiasTotais()
        );
    }

    public List<ReservaDTO> toDtoList(List<Reserva> entities) {
        if (entities == null) return null;
        
        return entities.stream()
                .map(this::toDto)
                .toList();
    }
}