package br.univille.fabsoft_backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva_tb")
public class Reserva {

    // arrumar os valores totais das tabelas


    private Long id;
    private LocalDate dataEvento;
    private Double valorTotal;
    private String observacoes;
    private Locatario locatario;
    private Espaco espaco;


    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Locatario locatario_bd;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Espaco espaco_bd;

    public Reserva() {}



    public Reserva(Long id, LocalDate dataEvento, Double valorTotal, String observacoes, Locatario locatario,
            Espaco espaco) {
        this.id = id;
        this.dataEvento = dataEvento;
        this.valorTotal = valorTotal;
        this.observacoes = observacoes;
        this.locatario = locatario;
        this.espaco = espaco;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }



    public Espaco getEspaco_bd() {
        return espaco_bd;
    }



    public void setEspaco_bd(Espaco espaco_bd) {
        this.espaco_bd = espaco_bd;
    }



    public Locatario getLocatario_bd() {
        return locatario_bd;
    }



    public void setLocatario_bd(Locatario locatario_bd) {
        this.locatario_bd = locatario_bd;
    }

    


    
}
