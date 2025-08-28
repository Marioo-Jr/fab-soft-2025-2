package br.univille.fabsoft_backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Locacao_tb")
public class Locacao {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate inicioLocacao;
    private LocalDate fimLocacao;
    private Double valorAluguel;
    private Locatario locatario;
    private Imovel imovel;
    


    @ManyToOne
    @JoinColumn(name = "Locatario_id")
    private Locatario locatario_bd;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario_bd;



    public Locacao (){}



    public Locacao(Long id, LocalDate inicioLocacao, LocalDate fimLocacao, Double valorAluguel, Locatario locatario,
            Imovel imovel) {
        this.id = id;
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.valorAluguel = valorAluguel;
        this.locatario = locatario;
        this.imovel = imovel;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInicioLocacao() {
        return inicioLocacao;
    }

    public void setInicioLocacao(LocalDate inicioLocacao) {
        this.inicioLocacao = inicioLocacao;
    }

    public LocalDate getFimLocacao() {
        return fimLocacao;
    }

    public void setFimLocacao(LocalDate fimLocacao) {
        this.fimLocacao = fimLocacao;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }


    public Imovel getImovel() {
        return imovel;
    }


    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }


    public Locatario getLocatario_bd() {
        return locatario_bd;
    }


    public void setLocatario_bd(Locatario locatario_bd) {
        this.locatario_bd = locatario_bd;
    }


    public Proprietario getProprietario_bd() {
        return proprietario_bd;
    }


    public void setProprietario_bd(Proprietario proprietario_bd) {
        this.proprietario_bd = proprietario_bd;
    }


    

}
