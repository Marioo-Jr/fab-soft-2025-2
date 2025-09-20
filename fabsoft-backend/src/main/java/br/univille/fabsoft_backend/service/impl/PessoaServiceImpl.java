package br.univille.fabsoft_backend.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
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

}
