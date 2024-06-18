package com.ucsm.proyecto.chambape.dto;

import com.ucsm.proyecto.chambape.model.Estado;

public record SubCategoriaDto(
    String nombre,
    String descripcion,
    Estado estado,
    Integer idCategoria
) {
    
}
