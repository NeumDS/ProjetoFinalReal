package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.TipoQuartoDTO;
import com.example.demo.entity.TipoQuarto;
import com.example.demo.mapper.TipoQuartoMapper;
import com.example.demo.repository.TipoQuartoRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoQuartoService {

    private final TipoQuartoMapper mapper;
    private final TipoQuartoRepository repository;

    public List<TipoQuartoDTO> listar() {
        return mapper.toDtoList(repository.findAll());
    }

    @Transactional
    public TipoQuartoDTO cadastrar(TipoQuartoDTO requestDto) {
        TipoQuarto cadastro = mapper.toEntity(requestDto);

        TipoQuarto cadastroSalvo = repository.save(cadastro);

        return mapper.toDto(cadastroSalvo);
}

    public TipoQuartoDTO buscarPorID(Long id) {
        TipoQuarto tipoQuarto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tipo de quarto não encontrado"));

        return mapper.toDto(tipoQuarto);
    }
    
    @Transactional
    public TipoQuartoDTO atualizar(Long id, TipoQuartoDTO requestDto) {
        TipoQuarto tipoQuarto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tipo de quarto não encontrado"));

        tipoQuarto.setNome(requestDto.nome());
        tipoQuarto.setDescricao(requestDto.descricao());
        tipoQuarto.setCapacidade(requestDto.capacidade());
        tipoQuarto.setValorDiaria(requestDto.valorDiaria());

        TipoQuarto TipoQuartoAtualizado = repository.save(tipoQuarto);

        return mapper.toDto(TipoQuartoAtualizado);

    }

    @Transactional
    public void excluir(Long id) {
        TipoQuarto tipoQuarto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tipo de quarto não encontrado"));

        tipoQuarto.setAtivo(false);

        repository.save(tipoQuarto);

            
    }

    public void reativar(Long id) {
        TipoQuarto tipoQuarto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tipo de quarto não encontrado"));

        tipoQuarto.setAtivo(true);

        repository.save(tipoQuarto);
        
    }

}
