package br.univille.fabsoft_backend.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.DTO.LocacaoDTO;
import br.univille.fabsoft_backend.entity.Imovel;
import br.univille.fabsoft_backend.entity.Locacao;
import br.univille.fabsoft_backend.entity.Pessoa;
import br.univille.fabsoft_backend.repository.ImovelRepository;
import br.univille.fabsoft_backend.repository.LocacaoRepository;
import br.univille.fabsoft_backend.repository.PessoaRepository;
import br.univille.fabsoft_backend.service.LocacaoService;
import br.univille.fabsoft_backend.service.exeptions.DatabaseException;
import br.univille.fabsoft_backend.service.exeptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class LocacaoImpl implements LocacaoService{


    @Autowired
    private LocacaoRepository locacaoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ImovelRepository imovelRepository;

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
            () -> new ResourceNotFoundException("Pessoa não encontrada com o id: " ));
        return toDTO(locacao);

    }


    public LocacaoDTO insert (LocacaoDTO dto){



        Locacao locacao = toEntity(dto);
        return toDTO(locacaoRepository.save(locacao));

    }

    public LocacaoDTO update (Long id, LocacaoDTO dto){
        
        Locacao locacao = locacaoRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Pessoa não encontrada com o id: " ));
        copyToDTO(dto, locacao);
        return toDTO(locacaoRepository.save(locacao));

    }

    public void delete (Long id){

        if (!locacaoRepository.existsById(id)) {
        throw new ResourceNotFoundException("Condomínio não encontrado com ID: " + id);
    }  
    try{
    locacaoRepository.deleteById(id);
    }catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }



    private LocacaoDTO toDTO(Locacao locacao) {
        LocacaoDTO dto = new LocacaoDTO();
        dto.setId(locacao.getId());
        dto.setInicioLocacao(locacao.getInicioLocacao());
        dto.setFimLocacao(locacao.getFimLocacao());
        dto.setValorAluguel(locacao.getValorAluguel());
        dto.setStatusLocacao(locacao.getStatusLocacao());

    
        if (locacao.getImovel() != null) {
            dto.setImovelId(locacao.getImovel().getId());
        }
        if (locacao.getLocatario() != null) {
            dto.setLocatarioId(locacao.getLocatario().getId());
        }

        return dto;
    }

    private Locacao toEntity(LocacaoDTO dto) {
        Locacao locacao = new Locacao();
        locacao.setId(dto.getId());
        locacao.setInicioLocacao(dto.getInicioLocacao());
        locacao.setFimLocacao(dto.getFimLocacao());
        locacao.setValorAluguel(dto.getValorAluguel());
        locacao.setStatusLocacao(dto.getStatusLocacao());

        // BUSCAR E SETAR OS OBJETOS
        if (dto.getImovelId() != null) {
            Imovel imovel = imovelRepository.findById(dto.getImovelId())
                .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado"));
            locacao.setImovel(imovel);
        }

        if (dto.getLocatarioId() != null) {
            Pessoa locatario = pessoaRepository.findById(dto.getLocatarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Locatario não encontrado"));
            locacao.setLocatario(locatario);
        }

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
    