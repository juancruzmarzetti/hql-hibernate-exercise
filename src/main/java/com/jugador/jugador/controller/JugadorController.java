package com.jugador.jugador.controller;

import com.jugador.jugador.dto.JugadorDTO;
import com.jugador.jugador.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    IJugadorService jugadorService;

    @GetMapping("/{name}")
    public ResponseEntity<JugadorDTO> buscarJugadorPorNombre(@PathVariable String name){
        ResponseEntity<JugadorDTO> response;
        JugadorDTO jugadorBuscado = jugadorService.buscarPorNombre(name);
        if(jugadorBuscado != null){
            response = ResponseEntity.ok(jugadorBuscado);
        }else{
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @PostMapping("/add")
    public ResponseEntity<JugadorDTO> buscarJugadorPorNombre(@RequestBody JugadorDTO jugadorDTO){
        ResponseEntity<JugadorDTO> response;
        JugadorDTO jugadorCreado = jugadorService.crearJugador(jugadorDTO);
        if(jugadorCreado != null){
            response = ResponseEntity.ok(jugadorCreado);
        }else{
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @GetMapping("/all")
    public ResponseEntity<Set<JugadorDTO>> buscarTodosLosJugadores(){
        ResponseEntity<Set<JugadorDTO>> response;
        Set<JugadorDTO> jugadores = jugadorService.obtenerTodos();
        if(jugadores != null){
            response = ResponseEntity.ok(jugadores);
        }else{
            response = ResponseEntity.noContent().build();
        }
        return response;
    }
}
