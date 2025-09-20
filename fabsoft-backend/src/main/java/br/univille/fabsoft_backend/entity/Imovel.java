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
public class Imovel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numero;
    private String bloco;
    private Integer qtdeQuartos;
    private Integer qtdeBanheiros;
    private Integer vagaGaragem;
    

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "condominio_id")
    private Condominio condominio_bd;

    @OneToMany(mappedBy = "imovel_bd",cascade = CascadeType.ALL)
    private List<Locacao> locacao_bd = new ArrayList<>();



    public Imovel (){}



    public Imovel(long id, String numero, String bloco, Integer qtdeQuartos, Integer qtdeBanheiros, Integer vagaGaragem) {
        this.id = id;
        this.numero = numero;
        this.bloco = bloco;
        this.qtdeQuartos = qtdeQuartos;
        this.qtdeBanheiros = qtdeBanheiros;
        this.vagaGaragem = vagaGaragem;
    }



    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getBloco() {
        return bloco;
    }


    public void setBloco(String bloco) {
        this.bloco = bloco;
    }


    public Integer getQtdeQuartos() {
        return qtdeQuartos;
    }


    public void setQtdeQuartos(Integer qtdeQuartos) {
        this.qtdeQuartos = qtdeQuartos;
    }


    public Integer getQtdeBanheiros() {
        return qtdeBanheiros;
    }


    public void setQtdeBanheiros(Integer qtdeBanheiros) {
        this.qtdeBanheiros = qtdeBanheiros;
    }


    public Integer getVagaGaragem() {
        return vagaGaragem;
    }


    public void setVagaGaragem(Integer vagaGaragem) {
        this.vagaGaragem = vagaGaragem;
    }



    public List<Locacao> getLocacao_bd() {
        return locacao_bd;
    }



    public void setLocacao_bd(List<Locacao> locacao_bd) {
        this.locacao_bd = locacao_bd;
    }



    public Condominio getCondominio_bd() {
        return condominio_bd;
    }



    public void setCondominio_bd(Condominio condominio_bd) {
        this.condominio_bd = condominio_bd;
    }

       

}
