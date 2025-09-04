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
@Table(name = "Locacao_tb")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Temporal(TemporalType.DATE) // era pra importar do jakarta ou jpa?
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inicioLocacao;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fimLocacao;
    
    private Double valorAluguel;

    


    @ManyToOne
    @JoinColumn(name = "locatario_id")
    private Locatario locatario_bd;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel_bd;



    public Locacao (){}



    public Locacao(long id, Date inicioLocacao, Date fimLocacao, Double valorAluguel) {
        this.id = id;
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.valorAluguel = valorAluguel;
    
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getInicioLocacao() {
        return inicioLocacao;
    }

    public void setInicioLocacao(Date inicioLocacao) {
        this.inicioLocacao = inicioLocacao;
    }

    public Date getFimLocacao() {
        return fimLocacao;
    }

    public void setFimLocacao(Date fimLocacao) {
        this.fimLocacao = fimLocacao;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }


    public Locatario getLocatario_bd() {
        return locatario_bd;
    }


    public void setLocatario_bd(Locatario locatario_bd) {
        this.locatario_bd = locatario_bd;
    }



    public Imovel getImovel_bd() {
        return imovel_bd;
    }



    public void setImovel_bd(Imovel imovel_bd) {
        this.imovel_bd = imovel_bd;
    }



    

}
