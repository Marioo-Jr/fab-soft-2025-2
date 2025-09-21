package br.univille.fabsoft_backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.univille.fabsoft_backend.DTO.CondominioDTO;

public interface CondominioService {

    CondominioDTO insert(CondominioDTO dto);
    CondominioDTO update (Long id, CondominioDTO dto);
    void delete(Long id);

    CondominioDTO findById(Long id);
    Page<CondominioDTO> findAll(Pageable pageable);



    
}
