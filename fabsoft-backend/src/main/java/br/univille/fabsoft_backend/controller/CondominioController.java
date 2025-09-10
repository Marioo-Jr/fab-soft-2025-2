package br.univille.fabsoft_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.fabsoft_backend.entity.Condominio;
import br.univille.fabsoft_backend.service.CondominioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/condominios")
public class CondominioController {

    @Autowired
    private CondominioService service;


    @GetMapping("/{id}")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public ResponseEntity<List<Condominio>> getAllCondominios() {
         var listaCondominio = service.getAll();
         return new ResponseEntity<List<Condominio>>(listaCondominio,HttpStatus.ok);

        return null;
    }


}
