package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservaDTO;
import com.example.demo.entity.Reserva;
import com.example.demo.entity.Quarto;
import com.example.demo.entity.Hospede;
import com.example.demo.mapper.ReservaMapper;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.QuartoRepository;
import com.example.demo.repository.HospedeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final QuartoRepository quartoRepository;
    private final HospedeRepository hospedeRepository;
    private final ReservaMapper reservaMapper;

    public List<ReservaDTO> listar() {
        return reservaMapper.toDtoList(reservaRepository.findByAtivoTrue());
    }

    public ReservaDTO buscarPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        return reservaMapper.toDto(reserva);
    }

    public ReservaDTO cadastrar(ReservaDTO dto) {
        Quarto quarto = quartoRepository.findById(dto.quartoId())
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        Hospede hospede = hospedeRepository.findById(dto.hospedeId())
                .orElseThrow(() -> new RuntimeException("Hóspede não encontrado"));

        Reserva reserva = reservaMapper.toEntity(dto, quarto, hospede);
        reserva.setAtivo(true);

        return reservaMapper.toDto(reservaRepository.save(reserva));
    }

    public ReservaDTO atualizar(Long id, ReservaDTO dto) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        Quarto quarto = quartoRepository.findById(dto.quartoId())
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        Hospede hospede = hospedeRepository.findById(dto.hospedeId())
                .orElseThrow(() -> new RuntimeException("Hóspede não encontrado"));

        reserva.setQuarto(quarto);
        reserva.setHospede(hospede);
        reserva.setValorDiaria(dto.valorDiaria());
        reserva.setDiasTotais(dto.diasTotais());

        return reservaMapper.toDto(reservaRepository.save(reserva));
    }

    public void excluir(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        reserva.setAtivo(false);
        reservaRepository.save(reserva);
    }
}