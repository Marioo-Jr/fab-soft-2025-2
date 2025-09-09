package br.univille.fabsoft_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.fabsoft_backend.entity.Locatario;

public interface LocatarioRepository extends JpaRepository<Locatario, Long> {

}
