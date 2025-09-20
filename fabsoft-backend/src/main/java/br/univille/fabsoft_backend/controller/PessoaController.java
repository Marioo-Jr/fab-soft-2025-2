package br.univille.fabsoft_backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public ResponseEntity<PessoaDTO> insert (@RequestBody PessoaDTO dto){
        dto = pessoaService.insert(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<PessoaDTO>> findAll (Pageable pegeable){
        Page<PessoaDTO> dto = pessoaService.findAll(pegeable);
        return ResponseEntity.ok(dto);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> update (@PathVariable Long id, @RequestBody PessoaDTO dto){

        dto = pessoaService.update(id, dto);
        return ResponseEntity.ok(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){

        pessoaService.delete(id);
        return ResponseEntity.noContent().build();

    }



}
