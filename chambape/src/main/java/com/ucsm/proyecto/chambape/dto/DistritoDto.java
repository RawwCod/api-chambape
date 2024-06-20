package com.ucsm.proyecto.chambape.dto;

import com.ucsm.proyecto.chambape.model.Estado;

public record DistritoDto(
    String nombre,
    Integer idDepartamento,
    Estado estado
) {
}
