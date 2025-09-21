package br.univille.fabsoft_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.univille.fabsoft_backend.DTO.CondominioDTO;
import br.univille.fabsoft_backend.entity.Condominio;
import br.univille.fabsoft_backend.entity.Pessoa;
import br.univille.fabsoft_backend.repository.CondominioRepository;
import br.univille.fabsoft_backend.repository.PessoaRepository;
import br.univille.fabsoft_backend.service.CondominioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class CondominioServiceImpl implements  CondominioService{

    @Autowired
    public CondominioRepository condominioRepository;

    @Autowired
    public PessoaRepository pessoaRepository;

    @Override
    public CondominioDTO findById(Long id){

        Condominio condominio = condominioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Imóvel não encontrado com ID: "));
        return toDTO(condominio);

    }



    @Override
    public Page<CondominioDTO> findAll (Pageable pageable){

        Page <Condominio> condominio = condominioRepository.findAll(pageable);
        return condominio.map(x -> toDTO(x));
    }


    @Override
    @Transactional
    public CondominioDTO insert (CondominioDTO dto){

        Condominio condominio = toEntity(dto);
        
        

        if (dto.getSindicoId() != null) {

            Pessoa sindico = pessoaRepository.findById(dto.getSindicoId()).orElseThrow(() -> new EntityNotFoundException("Síndico (Pessoa) não encontrado com ID: "));
            
            condominio.setSindico(sindico);
        } 
        return toDTO(condominioRepository.save(condominio));

    }



    @Override
    @Transactional
    public CondominioDTO update(Long id, CondominioDTO dto) {
        Condominio condominio = condominioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Condomínio não encontrado com ID: "));

        condominio = toEntity(dto);

        if (dto.getSindicoId() != null) {
            Pessoa sindico = pessoaRepository.findById(dto.getSindicoId())
                .orElseThrow(() -> new EntityNotFoundException("Síndico (Pessoa) não encontrado com ID: "));
            condominio.setSindico(sindico);
        } else {
            condominio.setSindico(null);
        }

        Condominio condominioAtualizado = condominioRepository.save(condominio);
        return toDTO(condominioAtualizado);
    }

    @Override
    @Transactional
    public void delete (Long id){
         if (!condominioRepository.existsById(id)) {
            throw new EntityNotFoundException("Imóvel não encontrado com ID: ");
        }

       condominioRepository.deleteById(id);

    }



    private CondominioDTO toDTO (Condominio condominio){

    CondominioDTO dto = new CondominioDTO();
        
    dto.setId(condominio.getId());
    dto.setNome(condominio.getNome());
    dto.setEndereco(condominio.getEndereco());
    dto.setCnpj(condominio.getCnpj());

    if (condominio.getSindico() != null) {
            dto.setSindicoId(condominio.getSindico().getId());
        }

    return dto;


    }

    private Condominio toEntity (CondominioDTO dto){
        Condominio condominio = new Condominio();

        condominio.setNome(dto.getNome());
        condominio.setEndereco(dto.getEndereco());
        condominio.setCnpj(dto.getCnpj());
        return condominio;

        

        


    }




}