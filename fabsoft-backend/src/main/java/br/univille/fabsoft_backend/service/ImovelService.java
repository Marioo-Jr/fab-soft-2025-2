package br.univille.fabsoft_backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.univille.fabsoft_backend.DTO.ImovelDTO;

public interface ImovelService {

    ImovelDTO insert(ImovelDTO dto);
    ImovelDTO update(Long id, ImovelDTO dto);
    void delete (Long id);

    ImovelDTO findById (Long id);   
    Page<ImovelDTO> findAll(Pageable pageable);
}
