package br.univille.fabsoft_backend.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.univille.fabsoft_backend.DTO.CondominioDTO;
import br.univille.fabsoft_backend.entity.Condominio;
import br.univille.fabsoft_backend.entity.Pessoa;
import br.univille.fabsoft_backend.repository.CondominioRepository;
import br.univille.fabsoft_backend.repository.ImovelRepository;
import br.univille.fabsoft_backend.repository.PessoaRepository;
import br.univille.fabsoft_backend.service.CondominioService;
import br.univille.fabsoft_backend.service.exeptions.DatabaseException;
import br.univille.fabsoft_backend.service.exeptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CondominioServiceImpl implements CondominioService{

    @Autowired
    public CondominioRepository condominioRepository;

    @Autowired
    public PessoaRepository pessoaRepository;

    @Autowired
    public ImovelRepository imovelRepository;

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

            Pessoa sindico = pessoaRepository.findById(dto.getSindicoId()).orElseThrow(() -> new ResourceNotFoundException("Síndico (Pessoa) não encontrado com ID: "));
            
            condominio.setSindico(sindico);
        } 
        return toDTO(condominioRepository.save(condominio));

    }



    @Override
    @Transactional
    public CondominioDTO update(Long id, CondominioDTO dto) {

        Condominio condominio = condominioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Condomínio não encontrado com ID: "));

        copyDtoToEntity(dto, condominio);

        if (dto.getSindicoId() != null) {
            Pessoa sindico = pessoaRepository.findById(dto.getSindicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Síndico (Pessoa) não encontrado com ID: "));
            condominio.setSindico(sindico);
        } else {
            condominio.setSindico(null);
        }

        return toDTO(condominioRepository.save(condominio));
    }

@Override
@Transactional
public void delete(Long id) {
    
    if (!condominioRepository.existsById(id)) {
        throw new ResourceNotFoundException("recurso nao encontrado");
    }
    try{

    condominioRepository.desassociarSindico(id);
    
    condominioRepository.deleteById(id);
    }catch (DataIntegrityViolationException e) {
        throw new DatabaseException("Falha de integridade referencial");
    }
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

    public void copyDtoToEntity (CondominioDTO dto, Condominio condominio){

        condominio.setCnpj(dto.getCnpj());
        condominio.setEndereco(dto.getEndereco());
        condominio.setNome(dto.getNome());

    }




}