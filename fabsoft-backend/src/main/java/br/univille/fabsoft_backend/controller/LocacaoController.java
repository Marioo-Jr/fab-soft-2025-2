package br.univille.fabsoft_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.fabsoft_backend.DTO.LocacaoDTO;
import br.univille.fabsoft_backend.service.LocacaoService;


@RestController
@RequestMapping("/api/v1/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @GetMapping
    public ResponseEntity<Page<LocacaoDTO>> findAll(Pageable pageable){

        Page<LocacaoDTO> dto = locacaoService.findAll(pageable);
        return ResponseEntity.ok(dto);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocacaoDTO> findByid(@PathVariable Long id){

        LocacaoDTO dto = locacaoService.findByid(id);
        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity <LocacaoDTO> insert (@RequestBody LocacaoDTO dto){

        dto = locacaoService.insert(dto);
        return ResponseEntity.ok(dto);

    } 

    @PutMapping (value = "/{id}")
    public ResponseEntity<LocacaoDTO> update (@PathVariable Long id, @RequestBody LocacaoDTO dto){

        dto = locacaoService.update(id, dto);
        return ResponseEntity.ok(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete (@PathVariable Long id){

        locacaoService.delete(id);
        return ResponseEntity.noContent().build();

    }
 


}
