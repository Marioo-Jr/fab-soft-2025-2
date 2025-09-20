package br.univille.fabsoft_backend.service;

import br.univille.fabsoft_backend.DTO.PessoaDTO;

public interface PessoaService {

    PessoaDTO findById(Long id);

}
