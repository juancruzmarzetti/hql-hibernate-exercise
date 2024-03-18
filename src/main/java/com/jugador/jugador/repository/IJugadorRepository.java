package com.jugador.jugador.repository;

import com.jugador.jugador.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJugadorRepository extends JpaRepository<Jugador, Long> {
    @Query("select j from Jugador j where j.nombre = ?1")
    Jugador findJugadorByName(String name);
}
