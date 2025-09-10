package br.univille.fabsoft_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.fabsoft_backend.entity.Espaco;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Long> {


}
