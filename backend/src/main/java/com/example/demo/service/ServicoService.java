package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ServicoDTO;
import com.example.demo.entity.Servico;
import com.example.demo.mapper.ServicoMapper;
import com.example.demo.repository.ServicoRepository;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ServicoService {
  
    private final ServicoRepository repository;
    private final ServicoMapper mapper;

    public List<ServicoDTO> listar() {
        return mapper.toDtoList(repository.findAll());
    }

    @Transactional 
    public ServicoDTO cadastrar(ServicoDTO requestDto) {
        Servico cadastro = mapper.toEntity(requestDto);

        Servico cadastroSalvo = repository.save(cadastro);

        return mapper.toDto(cadastroSalvo);
    }

    public ServicoDTO buscarPorID(Long id) {
        Servico servico = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        
       return mapper.toDto(servico);
    }

    @Transactional 
    public ServicoDTO atualizar(Long id, ServicoDTO requestDto) {
        Servico servico = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        servico.setNome(requestDto.nome());
        servico.setDescricao(requestDto.descricao());
        servico.setValorServico(requestDto.valorServico());

        Servico ServicoAtualizado = repository.save(servico);

        return mapper.toDto(ServicoAtualizado);
    }

    @Transactional 
    public void excluir(Long id) {
        Servico servico = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        servico.setAtivo(false);

        repository.save(servico);

    }

    public void reativar(Long id) {
        Servico servico = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
        
        servico.setAtivo(true);

        repository.save(servico);
        
    }

}
