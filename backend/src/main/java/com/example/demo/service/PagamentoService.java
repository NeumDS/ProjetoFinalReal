package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PagamentoDTO;
import com.example.demo.entity.Pagamento;
import com.example.demo.entity.Reserva;
import com.example.demo.mapper.PagamentoMapper;
import com.example.demo.repository.PagamentoRepository;
import com.example.demo.repository.ReservaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class PagamentoService {
    
    private final PagamentoRepository pagamentoRepository;
    private final ReservaRepository reservaRepository;
    private final PagamentoMapper mapper;

    public List<PagamentoDTO> listar() {
        return mapper.toDtoList(pagamentoRepository.findAll());
    }

    @Transactional 
    public PagamentoDTO cadastrar(PagamentoDTO requestDto) {
        Reserva reserva = reservaRepository.findById(requestDto.reservaId())
            .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        Pagamento pagamento = mapper.toEntity(requestDto, reserva);

        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);

        return mapper.toDto(pagamentoSalvo);
    }

    public PagamentoDTO buscarPorId(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        return mapper.toDto(pagamento);
    }

    @Transactional 
    public PagamentoDTO atualizar(Long id, PagamentoDTO requestDto) {
        Pagamento pagamento = pagamentoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
        
        pagamento.setValor(requestDto.valor());
        pagamento.setDataPagamento(requestDto.dataPagamento());
        pagamento.setFormaPagamento(requestDto.formaPagamento());
        pagamento.setStatusPagamento(requestDto.statusPagamento());
        
        return mapper.toDto(pagamentoRepository.save(pagamento));

    }

    
}
