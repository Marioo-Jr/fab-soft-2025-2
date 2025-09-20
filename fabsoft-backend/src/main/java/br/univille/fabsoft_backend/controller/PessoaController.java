package br.univille.fabsoft_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.fabsoft_backend.DTO.PessoaDTO;
import br.univille.fabsoft_backend.service.PessoaService;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @GetMapping(value = "/{id}")
    public ResponseEntity <PessoaDTO> findById(@PathVariable Long id){

        
        PessoaDTO dto = pessoaService.findById(id);
        return ResponseEntity.ok(dto);

    }

}
