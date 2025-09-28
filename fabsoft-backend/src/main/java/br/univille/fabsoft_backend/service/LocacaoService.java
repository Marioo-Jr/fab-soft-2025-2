package br.univille.fabsoft_backend.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.univille.fabsoft_backend.DTO.LocacaoDTO;


public interface LocacaoService {

   Page <LocacaoDTO> findAll(Pageable pageable);
   LocacaoDTO findByid(Long id);

   LocacaoDTO insert (LocacaoDTO dto);
   LocacaoDTO update (Long id, LocacaoDTO dto);
   void delete (Long id );

}
