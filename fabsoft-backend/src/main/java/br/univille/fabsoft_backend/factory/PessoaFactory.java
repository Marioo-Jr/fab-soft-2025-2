package br.univille.fabsoft_backend.factory;

import br.univille.fabsoft_backend.DTO.PessoaDTO;
import br.univille.fabsoft_backend.entity.Locatario;
import br.univille.fabsoft_backend.entity.Pessoa;
import br.univille.fabsoft_backend.entity.Proprietario;

public class PessoaFactory {


    public Pessoa criarPessoa(PessoaDTO dto){

        if (dto.getTipoPessoa() == null) {

            throw new IllegalArgumentException("O tipo da pessoa é obrigatorio.");
        }
        Pessoa pessoa;

        switch (dto.getTipoPessoa()) {
            case LOCATARIO:
                Locatario locatario = new Locatario();
                locatario.setEndereco(dto.getEndereco());
                pessoa = locatario;
                break;
        
            case PROPRIETARIO:
                pessoa = new Proprietario();
                break;
            default:
                throw new IllegalArgumentException("Tipo de pessoa inválido: " + dto.getTipoPessoa());
        }
        
        
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setEmail(dto.getEmail());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setDataNascimento(dto.getDataNascimento());

        return pessoa;
        

    }

    

}
