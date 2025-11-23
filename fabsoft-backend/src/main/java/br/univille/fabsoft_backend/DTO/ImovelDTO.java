package br.univille.fabsoft_backend.DTO;

import br.univille.fabsoft_backend.entity.StatusImovel;

public class ImovelDTO {

    private Long id;
    private String numero;
    private String bloco;
    private Integer qtdeQuartos;
    private Integer qtdeBanheiros;
    private Integer vagaGaragem;
    private StatusImovel statusImovel;
    private Long condominioId;
    private Long proprietarioId;
    private String nomeCondominio;
    private String nomeProprietario;
   

    public ImovelDTO(){}

    public ImovelDTO(Long id, String numero, String bloco, Integer qtdeQuartos, Integer qtdeBanheiros,Integer vagaGaragem ,StatusImovel statusImovel,
            Long condominioId, Long proprietarioId) {
        this.id = id;
        this.numero = numero;
        this.bloco = bloco;
        this.qtdeQuartos = qtdeQuartos;
        this.qtdeBanheiros = qtdeBanheiros;
        this.statusImovel = statusImovel;
        this.vagaGaragem = vagaGaragem;
        this.condominioId = condominioId;
        this.proprietarioId = proprietarioId;
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
    

    public StatusImovel getStatusImovel() {
        return statusImovel;
    }

    public void setStatusImovel(StatusImovel statusImovel) {
        this.statusImovel = statusImovel;
    }

    public Long getCondominioId() {
        return condominioId;
    }

    public void setCondominioId(Long condominioId) {
        this.condominioId = condominioId;
    }

    public Long getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Long proprietarioId) {
        this.proprietarioId = proprietarioId;
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

    public String getNomeCondominio() {
        return nomeCondominio;
    }

    public void setNomeCondominio(String nomeCondominio) {
        this.nomeCondominio = nomeCondominio;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    
    
    


}
