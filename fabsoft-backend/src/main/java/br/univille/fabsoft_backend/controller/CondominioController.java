package br.univille.fabsoft_backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.fabsoft_backend.service.CondominioService;




@RestController
@RequestMapping("/api/v1/condominios")
public class CondominioController {

    @Autowired
    private CondominioService service;


    

    

}
