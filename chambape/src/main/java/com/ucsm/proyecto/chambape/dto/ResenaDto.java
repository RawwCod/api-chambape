package com.ucsm.proyecto.chambape.dto;

import java.time.LocalDate;

public record ResenaDto(
    Integer idSolicitudServicio,
    Integer idProveedor,
    String comentario,
    String nombreProveedor,
    LocalDate fecha,
    Integer calificacion
) {
    
}
