package br.univille.fabsoft_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.fabsoft_backend.entity.Condominio;
import br.univille.fabsoft_backend.service.CondominioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/condominios")
public class CondominioController {

    @Autowired
    private CondominioService service;


    
    @GetMapping
    public ResponseEntity<List<Condominio>> getCondominios() {
         var listaCondominio = service.getAll();

         return new ResponseEntity<List<Condominio>>(listaCondominio,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Condominio> save(@RequestBody Condominio condominio){
        if (condominio == null){
            return ResponseEntity.badRequest().build();
        }
        if (condominio.getId()==0){
            condominio = service.save(condominio);
            return new ResponseEntity<Condominio>(condominio,HttpStatus.OK);
        
        }
        return ResponseEntity.badRequest().build();
    }


}
