
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

import br.univille.fabsoft_backend.DTO.EspacoDTO;
import br.univille.fabsoft_backend.service.EspacoService;



@RestController
@RequestMapping("/api/v1/espacos")
public class EspacoController {


    @Autowired
    EspacoService espacoService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<EspacoDTO> findById (Long id){

        EspacoDTO dto = espacoService.findById(id);
        return ResponseEntity.ok(dto);

    }


    @GetMapping
    public ResponseEntity<Page<EspacoDTO>> findAll (Pageable pageable){

        Page<EspacoDTO> espaco = espacoService.findAll(pageable);
        return ResponseEntity.ok(espaco);

    }  

    @PostMapping
    public ResponseEntity<EspacoDTO> insert (@RequestBody EspacoDTO dto){

        dto =  espacoService.insert(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);


    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<EspacoDTO> update (@PathVariable Long id, @RequestBody EspacoDTO dto ){


        dto = espacoService.update(id, dto);
        return ResponseEntity.ok(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete (@PathVariable Long id){

        espacoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
