package com.jugador.jugador.service;

import com.jugador.jugador.dto.JugadorDTO;

import java.util.List;
import java.util.Set;

public interface IJugadorService {

    JugadorDTO crearJugador(JugadorDTO jugadorDTO);
    Set<JugadorDTO> obtenerTodos();
    JugadorDTO buscarPorNombre(String name);
}
