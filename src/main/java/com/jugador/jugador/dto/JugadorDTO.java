package com.jugador.jugador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO {
    private Long id;
    private String nombre;
    private String clubFavorito;
}
