package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.PagamentoDTO;
import com.example.demo.entity.Pagamento;
import com.example.demo.entity.Reserva;

@Component 
public class PagamentoMapper {
    
    public Pagamento toEntity(PagamentoDTO dto, Reserva reserva) {

        return Pagamento.builder()
            .valor(dto.valor())
            .dataPagamento(dto.dataPagamento())
            .formaPagamento(dto.formaPagamento())
            .statusPagamento(dto.statusPagamento())
            .reserva(reserva)
            .build();
    }

    public PagamentoDTO toDto(Pagamento pagamento) {
       
        return new PagamentoDTO(
            pagamento.getId(),
            pagamento.getValor(),
            pagamento.getDataPagamento(),
            pagamento.getFormaPagamento(),
            pagamento.getStatusPagamento(),
            pagamento.getReserva().getId()
        );
    }

    public List<PagamentoDTO> toDtoList(List<Pagamento> entities) {
       if (entities == null) return null;

       return entities.stream()
            .map(this::toDto)
            .toList();
    }
}
