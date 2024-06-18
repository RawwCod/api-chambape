package com.ucsm.proyecto.chambape.dto;

import com.ucsm.proyecto.chambape.model.EstadoSolicitud;

public record CambioEstadoSolicitudDto(
    EstadoSolicitud estado,
    Integer idSolicitudServicio
) {
    
}
