package br.univille.fabsoft_backend.entity;

import jakarta.persistence.Entity;


@Entity
public class Locatario extends Pessoa {

    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
}
