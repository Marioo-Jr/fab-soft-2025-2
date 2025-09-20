package br.univille.fabsoft_backend.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;



@Entity
public class Condominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String endereco;
    private String cnpj;

    

    @OneToMany(mappedBy = "condominio_bd",cascade = CascadeType.ALL)
    private List<Espaco> espaco_bd = new ArrayList<>();


    @OneToMany(mappedBy = "condominio_bd")
    private List<Imovel> imovel_bd = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "sindico_id")
    private Pessoa pessoa;


    public Condominio () {}



    public Condominio(long id, String nome, String endereco, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
    
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



    public List<Espaco> getEspaco_bd() {
        return espaco_bd;
    }



    public void setEspaco_bd(List<Espaco> espaco_bd) {
        this.espaco_bd = espaco_bd;
    }



    public List<Imovel> getImovel_bd() {
        return imovel_bd;
    }



    public void setImovel_bd(List<Imovel> imovel_bd) {
        this.imovel_bd = imovel_bd;
    }


    

}
