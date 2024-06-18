package com.ucsm.proyecto.chambape.dto;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record UsuarioServicioDto(
    Integer idUsuario,
    Integer idServicio,

    Boolean estado,
    Integer calificacion,
    Double precio,
    File foto,
    String descripcion,
    UnidadCobro unidadCobro,
    Boolean pagoAnticipado,
    ArrayList<LocalDate> dias,
    ArrayList<LocalTime> horasInicio

) {



} 
