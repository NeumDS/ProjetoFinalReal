package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservaServicoDTO;
import com.example.demo.entity.Reserva;
import com.example.demo.entity.ReservaServico;
import com.example.demo.entity.Servico;
import com.example.demo.mapper.ReservaServicoMapper;
import com.example.demo.repository.ReservaServicoRepository;
import com.example.demo.repository.ServicoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReseervaServicoService {
    
    private final ReservaServicoMapper mapper;
    private final ReservaServicoRepository repository;
    private final ReservaRepository repository2;
    private final ServicoRepository repository3;

    public List<ReservaServicoDTO> listar() {
        return mapper.toDtoList(repository.findAll());
    }

    @Transactional
    public ReservaServicoDTO cadastrar(ReservaServicoDTO dto) {

        Reserva reserva = repository2.findById(dto.reservaId())
            .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        Servico servico = repository3.findById(dto.servicoId())
            .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        ReservaServico reservaServico = mapper.toEntity(dto, reserva, servico);

        return mapper.toDto(repository.save(reservaServico));
    }

    @Transactional
    public ReservaServicoDTO atualizar(Long id, ReservaServicoDTO dto) {
        ReservaServico reservaServico = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Serviço de reserva não encontrado"));

        reservaServico.setQuantidade(dto.quantidade());
        reservaServico.setValorUnitario(dto.valorUnitario());

        ReservaServico reservaServicoAtualizada = repository.save(reservaServico);

        return mapper.toDto(reservaServicoAtualizada);
    }

    @Transactional 
    public void excluir(Long id) {
        ReservaServico reservaServico = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Serviço de reserva não encontrado"));

        reservaServico.setAtivo(false);
        
        repository.save(reservaServico);

    }

    public void reativar(Long id) {
        ReservaServico reservaServico = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Serviço de reserva não encontrado"));
        
         reservaServico.setAtivo(true);
         
         repository.save(reservaServico);

    }

}
