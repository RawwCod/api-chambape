package com.ucsm.proyecto.chambape.dto;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public record ServicioDto(
    Integer idProveedor,
    String nombre,
    String descripcion,
    String imagen,
    Double precio,
    Integer idSubCategoria,
    Boolean estado,
    Boolean pagoAnticipado,
    UnidadCobro unidadCobro,
    ArrayList<LocalDate> diasDisponibles,
    ArrayList<LocalTime> horasDisponibles
    ) {
    
}
