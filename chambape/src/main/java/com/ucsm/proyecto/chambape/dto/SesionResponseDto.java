package com.ucsm.proyecto.chambape.dto;

import com.ucsm.proyecto.chambape.model.Tipo;

public record SesionResponseDto(
    Integer idUsuario,
    Tipo tipoUsuario
) {
}