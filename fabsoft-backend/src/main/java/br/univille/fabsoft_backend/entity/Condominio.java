package br.univille.fabsoft_backend.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "condominio_tb")
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String cnpj;
    private Locatario locatario;



    @OneToMany(mappedBy = "condominio_bd")
    private List<Espaco> espaco_bd = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel_bd;


    public Condominio () {}



    public Condominio(Long id, String nome, String endereco, String cnpj, Locatario sindico) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.locatario = sindico;
    }






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario sindico) {
        this.locatario = sindico;
    }



    public Imovel getImovel_bd() {
        return imovel_bd;
    }



    public void setImovel_bd(Imovel imovel_bd) {
        this.imovel_bd = imovel_bd;
    }



    public List<Espaco> getEspaco_bd() {
        return espaco_bd;
    }



    public void setEspaco_bd(List<Espaco> espaco_bd) {
        this.espaco_bd = espaco_bd;
    }


    

}
