package br.univille.fabsoft_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.fabsoft_backend.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    


}
