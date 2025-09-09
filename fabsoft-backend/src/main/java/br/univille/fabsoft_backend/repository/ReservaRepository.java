package br.univille.fabsoft_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.fabsoft_backend.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}
