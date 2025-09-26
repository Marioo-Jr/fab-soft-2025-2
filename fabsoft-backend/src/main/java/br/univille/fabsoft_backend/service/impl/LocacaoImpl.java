package br.univille.fabsoft_backend.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.univille.fabsoft_backend.DTO.LocacaoDTO;
import br.univille.fabsoft_backend.entity.Locacao;
import br.univille.fabsoft_backend.repository.LocacaoRepository;
import br.univille.fabsoft_backend.service.LocacaoService;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    @Transactional
    public LocacaoDTO findByid (Long id){

        Locacao locacao = locacaoRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Pessoa não encontrada com o id: " ));
        return toDTO(locacao);

    }


    public LocacaoDTO insert (LocacaoDTO dto){



        Locacao locacao = toEntity(dto);
        return toDTO(locacaoRepository.save(locacao));

    }

    public LocacaoDTO update (Long id, LocacaoDTO dto){

        Locacao locacao = locacaoRepository.findById(id).get();
        copyToDTO(dto, locacao);
        return toDTO(locacaoRepository.save(locacao));

    }

    public void delete (Long id){

        if (!locacaoRepository.existsById(id)) {
        throw new EntityNotFoundException("Condomínio não encontrado com ID: " + id);
    }   locacaoRepository.deleteById(id);
        
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


    private void copyToDTO (LocacaoDTO dto, Locacao entity){

        entity.setInicioLocacao(dto.getInicioLocacao());
        entity.setFimLocacao(dto.getFimLocacao());
        entity.setValorAluguel(dto.getValorAluguel());
        entity.setStatusLocacao(dto.getStatusLocacao());

    }


        
}
    // private long id;
    // private Date inicioLocacao;
    // private Date fimLocacao;
    // private Double valorAluguel;
    // private Long imovelId;
    // private Long locatarioId;
    