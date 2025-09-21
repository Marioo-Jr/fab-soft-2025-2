package br.univille.fabsoft_backend.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.DTO.ImovelDTO;
import br.univille.fabsoft_backend.entity.Condominio;
import br.univille.fabsoft_backend.entity.Imovel;
import br.univille.fabsoft_backend.entity.Proprietario;
import br.univille.fabsoft_backend.repository.CondominioRepository;
import br.univille.fabsoft_backend.repository.ImovelRepository;
import br.univille.fabsoft_backend.repository.PessoaRepository;
import br.univille.fabsoft_backend.service.ImovelService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class ImovelImpl implements ImovelService {


    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private CondominioRepository condominioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;



    @Override
    public ImovelDTO findById(Long id){

        Imovel result = imovelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Imóvel não encontrado com ID: " + id));;
        return toDTO(result);

    }


    @Override
    public Page<ImovelDTO> findAll(Pageable pageable){

        Page<Imovel> dto = imovelRepository.findAll(pageable);
        return dto.map(x -> toDTO(x));

    }

    @Override
    @Transactional
    public ImovelDTO insert (ImovelDTO dto){

        Condominio condominio = condominioRepository.findById(dto.getCondominioId()).
        orElseThrow(() -> new EntityNotFoundException("Condomínio não encontrado com ID "));

        Proprietario proprietario = (Proprietario) pessoaRepository.findById(dto.getProprietarioId()).
        orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrado com ID "));

        Imovel imovel = toEntity(dto);

        imovel.setCondominio(condominio);
        imovel.setProprietario(proprietario);
        
        return  toDTO(imovelRepository.save(imovel));


    }


    @Override
    @Transactional
    public ImovelDTO update (Long id, ImovelDTO dto){

        Imovel imovel = imovelRepository.findById(id)
        .orElseThrow((() -> new EntityNotFoundException("Imóvel não encontrado com ID: ")));

        CopyToEntity(dto, imovel);

        if (imovel.getCondominio().getId() != dto.getCondominioId()) {
            Condominio novoCondominio = condominioRepository.findById(dto.getCondominioId())
                .orElseThrow(() -> new EntityNotFoundException("Condomínio não encontrado com ID: "));
            imovel.setCondominio(novoCondominio);
        }


        if (imovel.getProprietario().getId() != (dto.getProprietarioId())) {
             Proprietario novoProprietario = (Proprietario) pessoaRepository.findById(dto.getProprietarioId())
                .orElseThrow(() -> new EntityNotFoundException("Proprietário não encontrado com ID: " ));
             imovel.setProprietario(novoProprietario);
        }  

        return toDTO(imovelRepository.save(imovel));


    }
    @Override
    @Transactional
    public void delete (Long id){
        if (!imovelRepository.existsById(id)) {
            throw new EntityNotFoundException("Imóvel não encontrado com ID: ");
        }

        imovelRepository.deleteById(id);
    }


    private ImovelDTO toDTO(Imovel imovel) {
        ImovelDTO dto = new ImovelDTO();
        dto.setId(imovel.getId());
        dto.setNumero(imovel.getNumero());
        dto.setBloco(imovel.getBloco());
        dto.setQtdeQuartos(imovel.getQtdeQuartos());
        dto.setStatusImovel(imovel.getStatusImovel());
        dto.setCondominioId(imovel.getCondominio().getId());
        dto.setProprietarioId(imovel.getProprietario().getId());
        return dto;
    }

    public Imovel toEntity (ImovelDTO dto){
        Imovel imovel = new Imovel();
        imovel.setNumero(dto.getNumero());
        imovel.setBloco(dto.getBloco());
        imovel.setQtdeQuartos(dto.getQtdeQuartos());
        imovel.setStatusImovel(dto.getStatusImovel());
        imovel.setQtdeBanheiros(dto.getQtdeBanheiros());
        imovel.setVagaGaragem(dto.getVagaGaragem());


        return imovel;

    }

    public void CopyToEntity (ImovelDTO dto, Imovel entity){

        entity.setNumero(dto.getNumero());
        entity.setBloco(dto.getBloco());
        entity.setQtdeBanheiros(dto.getQtdeBanheiros());
        entity.setQtdeQuartos(dto.getQtdeQuartos());


    }

}