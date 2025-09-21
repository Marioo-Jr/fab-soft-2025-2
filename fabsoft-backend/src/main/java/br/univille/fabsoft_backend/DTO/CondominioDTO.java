package br.univille.fabsoft_backend.DTO;

public class CondominioDTO {

    private long id;
    private String nome;
    private String endereco;
    private String cnpj;
    private Long sindicoId;

    public CondominioDTO (){}


    

    public CondominioDTO(long id, String nome, String endereco, String cnpj, Long sindicoId) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.sindicoId = sindicoId;
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

    public Long getSindicoId() {
        return sindicoId;
    }




    public void setSindicoId(Long sindicoId) {
        this.sindicoId = sindicoId;
    }


    

}
