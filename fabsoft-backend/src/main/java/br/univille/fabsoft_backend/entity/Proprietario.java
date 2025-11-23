package br.univille.fabsoft_backend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Proprietario extends Pessoa {


    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    
}
