package br.univille.fabsoft_backend.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.univille.fabsoft_backend.DTO.PessoaDTO;
import br.univille.fabsoft_backend.entity.Locatario;
import br.univille.fabsoft_backend.entity.Pessoa;
import br.univille.fabsoft_backend.entity.Proprietario;
import br.univille.fabsoft_backend.entity.TipoPessoa;
import br.univille.fabsoft_backend.factory.PessoaFactory;
import br.univille.fabsoft_backend.repository.PessoaRepository;
import br.univille.fabsoft_backend.service.PessoaService;
import jakarta.persistence.EntityNotFoundException;


@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaFactory pessoaFactory;

    @Override
    public PessoaDTO findById(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com o id: " + id));
        return toDTO(pessoa);

    }
    
    @Override
    public Page<PessoaDTO> findAll(Pageable pageable) {
        Page<Pessoa>  result = pessoaRepository.findAll(pageable);
        return result.map( x -> this.toDTO(x));

    }

    @Override
    public PessoaDTO insert(PessoaDTO dto){

        Pessoa pessoa = pessoaFactory.criarPessoa(dto);
        pessoa = pessoaRepository.save(pessoa);
        return toDTO(pessoa);

    }

    @Override
    public PessoaDTO update (Long id, PessoaDTO dto){

        Pessoa result = pessoaRepository.getReferenceById(id);
        copyDtoToEntity(dto, result);
        if (result instanceof Locatario) {
            ((Locatario) result).setEndereco(dto.getEndereco());
        }
        //Pessoa newPessoa = pessoaRepository.save(result);
        //return toDTO(newPessoa);
        return toDTO(pessoaRepository.save(result));


    }

    @Override
    public void delete(Long id){

        if (!pessoaRepository.existsById(id)) {
            throw new EntityNotFoundException("not found");
            
        }
        pessoaRepository.deleteById(id);
    }// nao consegui fazer o retorno do DELETE

    
    private PessoaDTO toDTO(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getCpf());
        dto.setDataNascimento(pessoa.getDataNascimento());
        dto.setEmail(pessoa.getEmail());
        dto.setTelefone(pessoa.getTelefone());
        
        if (pessoa instanceof Proprietario) {
            dto.setTipoPessoa(TipoPessoa.PROPRIETARIO);
        } else if (pessoa instanceof Locatario) {
            dto.setTipoPessoa(TipoPessoa.LOCATARIO);
            dto.setEndereco(((Locatario) pessoa).getEndereco());
        }

        return dto;
    }


    public void copyDtoToEntity(PessoaDTO dto, Pessoa pessoa) {
    pessoa.setCpf(dto.getCpf());
    pessoa.setEmail(dto.getEmail());
    pessoa.setTelefone(dto.getTelefone());
    pessoa.setDataNascimento(dto.getDataNascimento());
    pessoa.setNome(dto.getNome()); 

    
    if (pessoa instanceof Locatario && dto.getEndereco() != null) {
        ((Locatario) pessoa).setEndereco(dto.getEndereco());
    }

    }
}
