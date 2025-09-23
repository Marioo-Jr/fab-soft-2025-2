package br.univille.fabsoft_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.fabsoft_backend.entity.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long> {

    @Modifying
    @Query("UPDATE Condominio c SET c.sindico = NULL WHERE c.id = :condominioId")
    void desassociarSindico(@Param("condominioId") Long condominioId);
}
