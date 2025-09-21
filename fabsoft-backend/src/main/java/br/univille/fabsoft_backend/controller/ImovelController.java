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
import br.univille.fabsoft_backend.DTO.ImovelDTO;
import br.univille.fabsoft_backend.service.ImovelService;

@RestController
@RequestMapping("/api/v1/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @GetMapping(value = "/{id}")
    public ResponseEntity <ImovelDTO> findById(@PathVariable Long id){

        ImovelDTO dto = imovelService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ImovelDTO>> findAll(Pageable pageable){

        Page<ImovelDTO> dto = imovelService.findAll(pageable);
        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity<ImovelDTO> insert(@RequestBody ImovelDTO dto){

      dto = imovelService.insert(dto);
      return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ImovelDTO>  update (@PathVariable Long id, @RequestBody ImovelDTO dto){
        dto = imovelService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        imovelService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
