 package br.univille.fabsoft_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.DTO.EspacoDTO;
import br.univille.fabsoft_backend.entity.Espaco;
import br.univille.fabsoft_backend.repository.EspacoRepository;
import br.univille.fabsoft_backend.service.EspacoService;
import br.univille.fabsoft_backend.service.exeptions.DatabaseException;
import br.univille.fabsoft_backend.service.exeptions.ResourceNotFoundException;
@Service
public class EspacoImpl implements EspacoService {

    @Autowired
    EspacoRepository espacoRepository;



    @Override
    public EspacoDTO findById (Long id){

        Espaco espaco = espacoRepository.findById(id).orElseThrow((
            () -> new ResourceNotFoundException("Imóvel não encontrado com ID: " + id)));
        
        return toDTO(espaco);

    }
    
    @Override
    public Page <EspacoDTO> findAll (Pageable pageable){

        Page <Espaco> espaco = espacoRepository.findAll(pageable);
        return espaco.map(x -> toDTO(x));

    }



    @Override
    public EspacoDTO insert (EspacoDTO dto){

        Espaco espaco = toEntity(dto);
        return toDTO(espacoRepository.save(espaco));

    }

    public EspacoDTO update (Long id, EspacoDTO dto){

        Espaco espaco = espacoRepository.findById(id)
            .orElseThrow((() -> new ResourceNotFoundException("Imóvel não encontrado com ID: " + id)));
        
        CopyToEntity(espaco, dto);
        

        return toDTO(espacoRepository.save(espaco));
    }

    public void delete (Long id){

        if (!espacoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Imóvel não encontrado com ID: " + id);
            
        }
        try {
        espacoRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }



    private EspacoDTO toDTO (Espaco espaco){

        EspacoDTO dto = new EspacoDTO();

        dto.setId(espaco.getId());
        dto.setCapacidadeMaxima(espaco.getCapacidadeMaxima());
        dto.setDescricao(espaco.getDescricao());
        dto.setNome(espaco.getNome());
        dto.setValorReserva(espaco.getValorReserva());
        return dto;

    }
    


    private Espaco toEntity (EspacoDTO dto){
        Espaco espaco = new Espaco();

        espaco.setId(dto.getId());
        espaco.setNome(dto.getNome());
        espaco.setDescricao(dto.getDescricao());
        espaco.setCapacidadeMaxima(dto.getCapacidadeMaxima());
        espaco.setValorReserva(dto.getValorReserva());

        return espaco;

    }

    public void CopyToEntity (Espaco espaco, EspacoDTO dto){

        espaco.setNome(dto.getNome());
        espaco.setCapacidadeMaxima(dto.getCapacidadeMaxima());
        espaco.setDescricao(dto.getDescricao());
        espaco.setValorReserva(dto.getValorReserva());

    }

}

// private long id;
//     private String nome;
//     private String descricao;
//     private Integer capacidadeMaxima;
//     private Double valorReserva;
