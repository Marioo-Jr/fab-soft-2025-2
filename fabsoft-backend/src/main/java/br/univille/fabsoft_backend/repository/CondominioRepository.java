package br.univille.fabsoft_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fabsoft_backend.entity.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long> {

}
