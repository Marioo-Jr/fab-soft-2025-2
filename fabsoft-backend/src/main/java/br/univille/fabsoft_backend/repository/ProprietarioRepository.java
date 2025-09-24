package br.univille.fabsoft_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fabsoft_backend.entity.Proprietario;

@Repository
public interface ProprietarioRepository extends JpaRepository <Proprietario, Long> {

}
