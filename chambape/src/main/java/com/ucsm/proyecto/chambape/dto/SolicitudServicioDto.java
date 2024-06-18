package com.ucsm.proyecto.chambape.dto;

public record SolicitudServicioDto(
    String descripcion,
    Integer idCliente,
    Integer idUsuarioServicio
) {
    
}
