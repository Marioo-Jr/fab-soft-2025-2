package br.univille.fabsoft_backend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "imovel_tb")
public class Imovel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String bloco;
    private Integer qtdeQuartos;
    private Integer qtdeBanheiros;
    private Integer vagaGaragem;
    private Condominio condominio;
    private Proprietario proprietario;

    

    @OneToMany(mappedBy = "imovel_bd")
    private List<Condominio> condominio_bd = new ArrayList<>();

    @OneToOne(mappedBy = "Imovel", cascade = CascadeType.ALL)
    private Locatario locatario_bd;



    public Imovel (){}



    public Imovel(Long id, String numero, String bloco, Integer qtdeQuartos, Integer qtdeBanheiros, Integer vagaGaragem,
            Proprietario proprietario) {
        this.id = id;
        this.numero = numero;
        this.bloco = bloco;
        this.qtdeQuartos = qtdeQuartos;
        this.qtdeBanheiros = qtdeBanheiros;
        this.vagaGaragem = vagaGaragem;
        this.proprietario = proprietario;
    }





    public Long getId() {
        return id;
    }


    public void setId(Long id) {
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


    public Proprietario getProprietario() {
        return proprietario;
    }


    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }



    


    public Locatario getLocatario_bd() {
        return locatario_bd;
    }





    public void setLocatario_bd(Locatario locatario_bd) {
        this.locatario_bd = locatario_bd;
    }



    public Condominio getCondominio() {
        return condominio;
    }



    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }



    public List<Condominio> getCondominio_bd() {
        return condominio_bd;
    }



    public void setCondominio_bd(List<Condominio> condominio_bd) {
        this.condominio_bd = condominio_bd;
    }

    
    

   

    

}
