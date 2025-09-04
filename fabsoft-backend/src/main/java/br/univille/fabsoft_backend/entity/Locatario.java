package br.univille.fabsoft_backend.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Locatario_tb")
public class Locatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private LocalTime dataDeNascimento; // era pra ser date?


    @OneToMany(mappedBy = "locatario_bd")
    private List<Reserva> reserva_bd = new ArrayList<>();




    @OneToMany(mappedBy = "locatario_bd")
    private List<Locacao> locacao_bd = new ArrayList<>();
    
    
    public Locatario(){}

    
    public Locatario(long id, String nome, String cpf, String endereco, String telefone, LocalTime dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataDeNascimento = dataDeNascimento;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public LocalTime getDataDeNascimento() {
        return dataDeNascimento;
    }
    public void setDataDeNascimento(LocalTime dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }


    public List<Locacao> getLocacao_bd() {
        return locacao_bd;
    }


    public void setLocacao_bd(List<Locacao> locacao_bd) {
        this.locacao_bd = locacao_bd;
    }


    public List<Reserva> getReserva_bd() {
        return reserva_bd;
    }


    public void setReserva_bd(List<Reserva> reserva_bd) {
        this.reserva_bd = reserva_bd;
    }

    
    
}
