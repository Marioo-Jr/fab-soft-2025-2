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

import br.univille.fabsoft_backend.DTO.CondominioDTO;
import br.univille.fabsoft_backend.service.CondominioService;




@RestController
@RequestMapping("/api/v1/condominios")
public class CondominioController {

    @Autowired
    private CondominioService condominioService;
    

    @GetMapping(value = "/{id}")
    public ResponseEntity<CondominioDTO> findById (@PathVariable Long id){

        CondominioDTO dto = condominioService.findById(id);
        return ResponseEntity.ok(dto);
    }

    
    @GetMapping
    public ResponseEntity<Page<CondominioDTO>> findAll (Pageable pageable){

        Page<CondominioDTO> dto = condominioService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CondominioDTO> insert (@RequestBody CondominioDTO dto){

        dto = condominioService.insert(dto);
        return ResponseEntity.ok(dto);

    }
    @PutMapping("/{id}")
    public ResponseEntity<CondominioDTO> update (@PathVariable Long id, @RequestBody CondominioDTO dto) {
        dto = condominioService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        condominioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    

}
