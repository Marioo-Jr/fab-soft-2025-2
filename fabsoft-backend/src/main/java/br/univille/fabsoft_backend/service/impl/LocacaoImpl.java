package br.univille.fabsoft_backend.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.univille.fabsoft_backend.DTO.LocacaoDTO;
import br.univille.fabsoft_backend.entity.Locacao;
import br.univille.fabsoft_backend.repository.LocacaoRepository;
import br.univille.fabsoft_backend.service.LocacaoService;
import jakarta.transaction.Transactional;

public class LocacaoImpl implements LocacaoService{


    @Autowired
    private LocacaoRepository locacaoRepository;


    @Override
    @Transactional
    public Page<LocacaoDTO> findAll(Pageable pageable) {
        Page<Locacao> result = locacaoRepository.findAll(pageable);
        
        return result.map(x ->  toDTO(x));


    }

    private LocacaoDTO toDTO (Locacao locacao){
        LocacaoDTO dto = new LocacaoDTO();

        dto.setId(locacao.getId());
        dto.setInicioLocacao(locacao.getInicioLocacao());
        dto.setFimLocacao(locacao.getFimLocacao());
        dto.setValorAluguel(locacao.getValorAluguel());
        dto.setStatusLocacao(locacao.getStatusLocacao());

        

        return dto;


    }

    private Locacao toEntity (LocacaoDTO dto){

        Locacao locacao = new Locacao();

        locacao.setId(dto.getId());
        locacao.setFimLocacao(dto.getFimLocacao());
        locacao.setInicioLocacao(dto.getInicioLocacao());
        locacao.setStatusLocacao(dto.getStatusLocacao());
        locacao.setValorAluguel(dto.getValorAluguel());

        return locacao;

    }


        
}
    // private long id;
    // private Date inicioLocacao;
    // private Date fimLocacao;
    // private Double valorAluguel;
    // private Long imovelId;
    // private Long locatarioId;
    