package br.univille.fabsoft_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.entity.Condominio;
import br.univille.fabsoft_backend.repository.CondominioRepository;
import br.univille.fabsoft_backend.service.CondominioService;

@Service
public class CondominioServiceImpl implements  CondominioService{

    
    @Autowired
    private CondominioRepository repository;

    @Override
    public List<Condominio> getAll() {
        
        return repository.findAll();
        
    }

    @Override
    public Condominio save(Condominio condominio) {
        return repository.save(condominio);
    }

    @Override
    public Condominio update(long id, Condominio condominio) {
        
        return null;
    }

    




}
