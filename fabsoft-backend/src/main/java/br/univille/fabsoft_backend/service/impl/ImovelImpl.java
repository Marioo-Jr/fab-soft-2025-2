package br.univille.fabsoft_backend.service.impl;

import java.util.Objects;
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
import br.univille.fabsoft_backend.repository.ProprietarioRepository;
import br.univille.fabsoft_backend.service.ImovelService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImovelImpl implements ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    @Autowired
    private CondominioRepository condominioRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Override
    @Transactional(readOnly = true)
    public ImovelDTO findById(Long id){
        Imovel result = imovelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Imóvel não encontrado com ID: " + id));
        return toDTO(result);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ImovelDTO> findAll(Pageable pageable){
        Page<Imovel> imovel = imovelRepository.findAll(pageable);
        return imovel.map(this::toDTO);
    }

    @Override
    @Transactional
    public ImovelDTO insert (ImovelDTO dto){
        Condominio condominio = condominioRepository.findById(dto.getCondominioId())
            .orElseThrow(() -> new EntityNotFoundException("Condomínio não encontrado com ID: " + dto.getCondominioId()));

        Proprietario proprietario = proprietarioRepository.findById(dto.getProprietarioId())
            .orElseThrow(() -> new EntityNotFoundException("Proprietário não encontrado com ID: " + dto.getProprietarioId()));

        Imovel imovel = toEntity(dto);
        imovel.setCondominio(condominio);
        imovel.setProprietario(proprietario);
        
        return toDTO(imovelRepository.save(imovel));
    }

    @Override
    @Transactional
    public ImovelDTO update (Long id, ImovelDTO dto){
        Imovel imovel = imovelRepository.findById(id)
            .orElseThrow((() -> new EntityNotFoundException("Imóvel não encontrado com ID: " + id)));

        CopyToEntity(dto, imovel);

        if (!Objects.equals(imovel.getCondominio().getId(), dto.getCondominioId())) {
            Condominio novoCondominio = condominioRepository.findById(dto.getCondominioId())
                .orElseThrow(() -> new EntityNotFoundException("Condomínio não encontrado com ID: " + dto.getCondominioId()));
            imovel.setCondominio(novoCondominio);
        }

        if (!Objects.equals(imovel.getProprietario().getId(), dto.getProprietarioId())) {
            Proprietario novoProprietario = proprietarioRepository.findById(dto.getProprietarioId())
                .orElseThrow(() -> new EntityNotFoundException("Proprietário não encontrado com ID: " + dto.getProprietarioId()));
            imovel.setProprietario(novoProprietario);
        }  

        return toDTO(imovelRepository.save(imovel));
    }

    @Override
    @Transactional
    public void delete (Long id){
        if (!imovelRepository.existsById(id)) {
            throw new EntityNotFoundException("Imóvel não encontrado com ID: " + id);
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
        dto.setQtdeBanheiros(imovel.getQtdeBanheiros());
        dto.setVagaGaragem(imovel.getVagaGaragem());
        
        if (imovel.getCondominio() != null) {
            dto.setCondominioId(imovel.getCondominio().getId());
        }

        if (imovel.getProprietario() != null) {
            dto.setProprietarioId(imovel.getProprietario().getId());
        }

        return dto;
    }

    private Imovel toEntity (ImovelDTO dto){
        Imovel imovel = new Imovel();
        imovel.setNumero(dto.getNumero());
        imovel.setBloco(dto.getBloco());
        imovel.setQtdeQuartos(dto.getQtdeQuartos());
        imovel.setStatusImovel(dto.getStatusImovel());
        imovel.setQtdeBanheiros(dto.getQtdeBanheiros());
        imovel.setVagaGaragem(dto.getVagaGaragem());
        return imovel;
    }

    private void CopyToEntity (ImovelDTO dto, Imovel entity){
        entity.setNumero(dto.getNumero());
        entity.setBloco(dto.getBloco());
        entity.setQtdeBanheiros(dto.getQtdeBanheiros());
        entity.setQtdeQuartos(dto.getQtdeQuartos());
        entity.setVagaGaragem(dto.getVagaGaragem()); 
        entity.setStatusImovel(dto.getStatusImovel());
    }
}