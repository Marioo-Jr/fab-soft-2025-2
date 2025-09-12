package br.univille.fabsoft_backend.service;

import java.util.List;

import br.univille.fabsoft_backend.entity.Condominio;

public interface CondominioService {

    List<Condominio> getAll();
    Condominio save (Condominio condominio);
}
