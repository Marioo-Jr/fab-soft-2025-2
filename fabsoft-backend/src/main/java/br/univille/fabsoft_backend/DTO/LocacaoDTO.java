package br.univille.fabsoft_backend.DTO;
import java.util.Date;

import br.univille.fabsoft_backend.entity.StatusLocacao;

public class LocacaoDTO {

    private long id;
    private Date inicioLocacao;
    private Date fimLocacao;
    private Double valorAluguel;
    private Long imovelId;
    private Long locatarioId;
    private StatusLocacao statusLocacao;
    
    
    public LocacaoDTO(){}

    
    
    public LocacaoDTO(long id, Date inicioLocacao, Date fimLocacao, Double valorAluguel, Long imovelId, Long locatarioId,StatusLocacao statusLocacao) {
        this.id = id;
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.valorAluguel = valorAluguel;
        this.imovelId = imovelId;
        this.locatarioId = locatarioId;
        this.statusLocacao = statusLocacao;
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
    public Long getImovelId() {
        return imovelId;
    }
    public void setImovelId(Long imovelId) {
        this.imovelId = imovelId;
    }
    public Long getLocatarioId() {
        return locatarioId;
    }
    public void setLocatarioId(Long locatarioId) {
        this.locatarioId = locatarioId;
    }



    public StatusLocacao getStatusLocacao() {
        return statusLocacao;
    }



    public void setStatusLocacao(StatusLocacao statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    
    
    

}
