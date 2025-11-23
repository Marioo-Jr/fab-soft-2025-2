package br.univille.fabsoft_backend.entity;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
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

    @Enumerated(EnumType.STRING)
    private StatusLocacao statusLocacao;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "imovel")
    private Imovel imovel;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "locatario_id")
    private Pessoa locatario;

    public Locacao (){}




    public Locacao(long id, Date inicioLocacao, Date fimLocacao, Double valorAluguel, StatusLocacao statusLocacao, Imovel imovel_bd) {
        this.id = id;
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.valorAluguel = valorAluguel;
        this.statusLocacao = statusLocacao;
        this.imovel = imovel_bd;
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

    public Imovel getImovel() {
        return imovel;
    }



    public void setImovel(Imovel imovel_bd) {
        this.imovel = imovel_bd;
    }



    public StatusLocacao getStatusLocacao() {
        return statusLocacao;
    }



    public void setStatusLocacao(StatusLocacao statusLocacao) {
        this.statusLocacao = statusLocacao;
    }




    public Pessoa getLocatario() {
        return locatario;
    }




    public void setLocatario(Pessoa locatario) {
        this.locatario = locatario;
    }



    

}
