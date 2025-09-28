package br.univille.fabsoft_backend.DTO;

public class EspacoDTO {

    private long id;
    private String nome;
    private String descricao;
    private Integer capacidadeMaxima;
    private Double valorReserva;


    public EspacoDTO () {}


    public EspacoDTO(long id, String nome, String descricao, Integer capacidadeMaxima, Double valorReserva) {
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


    

}
