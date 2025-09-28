package br.univille.fabsoft_backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.univille.fabsoft_backend.DTO.EspacoDTO;

public interface EspacoService {



    Page <EspacoDTO> findAll (Pageable pageable);
    EspacoDTO findById(Long id);

    EspacoDTO update (Long id, EspacoDTO dto);
    EspacoDTO insert(EspacoDTO dto);
    void delete (Long id);

}
