package br.univille.fabsoft_backend.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.univille.fabsoft_backend.DTO.PessoaDTO;

public interface PessoaService {
    PessoaDTO insert (PessoaDTO dto);
    PessoaDTO update (Long id, PessoaDTO dto);
    void delete (Long id);
    
    Page<PessoaDTO> findAll (Pageable pageable);
    PessoaDTO findById(Long id);

}
