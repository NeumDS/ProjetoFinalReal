// package com.example.demo.mapper;

// import org.springframework.stereotype.Component;

// import com.example.demo.dto.HospedeDTO;
// import com.example.demo.entity.Hospede;

// @Component
// public class HospedeMapper {
    
//     public Hospede toEntity(HospedeDTO dto) {
//         return Hospede.builder()
//             .cpf(dto.cpf())
//             .nome(dto.nome())
//             .idade(dto.idade())
//             .build();

//     }

//     public HospedeDTO tDto(Hospede entity) {
//         if (entity == null) return null;
//         return new HospedeDTO(
//             entity.getId(),
//             entity.getCpf(),
//             entity.getNome(),
//             entity.getIdade()

//         );
//     }

// }
