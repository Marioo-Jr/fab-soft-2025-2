package br.univille.fabsoft_backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.fabsoft_backend.DTO.LocacaoDTO;
import br.univille.fabsoft_backend.service.LocacaoService;


@RestController
@RequestMapping("/api/v1/locacoes")
public class LocacaoController {


    private LocacaoService locacaoService;

    public ResponseEntity<Page<LocacaoDTO>> findAll(Pageable pageable){

        Page<LocacaoDTO> dto = locacaoService.findAll(pageable);
        return ResponseEntity.ok(dto);
        


    }


 


}
