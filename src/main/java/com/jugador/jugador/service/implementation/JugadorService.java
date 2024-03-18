package com.jugador.jugador.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jugador.jugador.dto.JugadorDTO;
import com.jugador.jugador.entity.Jugador;
import com.jugador.jugador.repository.IJugadorRepository;
import com.jugador.jugador.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JugadorService implements IJugadorService {

    @Autowired
    IJugadorRepository jugadorRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public JugadorDTO crearJugador(JugadorDTO jugadorDTO) {
        Jugador jugadorACrear = mapper.convertValue(jugadorDTO, Jugador.class);
        Jugador jugadorCreado = jugadorRepository.save(jugadorACrear);
        return mapper.convertValue(jugadorCreado, JugadorDTO.class);
    }

    @Override
    public Set<JugadorDTO> obtenerTodos() {
        List<Jugador> jugadores = jugadorRepository.findAll();
        Set<JugadorDTO> jugadoresDTO = new HashSet<>();
        for(Jugador jugador: jugadores){
            jugadoresDTO.add(mapper.convertValue(jugador, JugadorDTO.class));
        }
        if(jugadoresDTO.isEmpty()){
            return null;
        }
        return jugadoresDTO;
    }

    @Override
    public JugadorDTO buscarPorNombre(String name) {
        Jugador jugadorBuscadoPorNombre = jugadorRepository
                .findJugadorByName(name);
        JugadorDTO jugadorParseToDto = mapper
                .convertValue(jugadorBuscadoPorNombre, JugadorDTO.class);
        return jugadorParseToDto;
    }
}
