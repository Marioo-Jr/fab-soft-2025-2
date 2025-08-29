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

    


    @ManyToOne
    @JoinColumn(name = "locatario_id")
    private Locatario locatario_bd;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel_bd;



    public Locacao (){}



    public Locacao(Long id, LocalDate inicioLocacao, LocalDate fimLocacao, Double valorAluguel) {
        this.id = id;
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.valorAluguel = valorAluguel;
    
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
