package com.ucsm.proyecto.chambape.dto;

import java.io.File;

import com.ucsm.proyecto.chambape.model.Estado;

public record CategoriaDto(
    String nombre,
    File imagen,
    String descripcion,
    Estado estado
) {
} 