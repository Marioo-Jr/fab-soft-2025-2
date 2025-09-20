package br.univille.fabsoft_backend.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Espaco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private Integer capacidadeMaxima;
    private Double valorReserva;



    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "condominio_id")
    private Condominio condominio_bd;
    
    
    @OneToMany(mappedBy = "espaco_bd",cascade = CascadeType.ALL)
    private List<Reserva> reserva_bd = new ArrayList<>();
     

    
    public Espaco (){}
    
    public Espaco(long id, String nome, String descricao, Integer capacidadeMaxima, Double valorReserva,
    Condominio condominio) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.valorReserva = valorReserva;
    
    }
    



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public Double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(Double valorReserva) {
        this.valorReserva = valorReserva;
    }


    
    public List<Reserva> getReserva_bd() {
        return reserva_bd;
    }

    public void setReserva_bd(List<Reserva> reserva_bd) {
        this.reserva_bd = reserva_bd;
    }

    public Condominio getCondominio_bd() {
        return condominio_bd;
    }

    public void setCondominio_bd(Condominio condominio_bd) {
        this.condominio_bd = condominio_bd;
    }



    
    
    
}
