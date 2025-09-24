package br.univille.fabsoft_backend.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.DTO.LocacaoDTO;

@Service
public interface LocacaoService {

   Page <LocacaoDTO> findAll(Pageable pageable);


}
