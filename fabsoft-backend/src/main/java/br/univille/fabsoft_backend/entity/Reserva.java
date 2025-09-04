package br.univille.fabsoft_backend.entity;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "reserva_tb")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataEvento; // date era pra importar do sql ou jpa?

    private Double valorTotal;
    private String observacoes;



    @ManyToOne
    @JoinColumn(name = "reserva_locatario_id")
    private Locatario locatario_bd;

    @ManyToOne
    @JoinColumn(name = "reserva_espaco_id")
    private Espaco espaco_bd;

    public Reserva() {}



    public Reserva(long id, Date dataEvento, Double valorTotal, String observacoes) {
        this.id = id;
        this.dataEvento = dataEvento;
        this.valorTotal = valorTotal;
        this.observacoes = observacoes;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
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
