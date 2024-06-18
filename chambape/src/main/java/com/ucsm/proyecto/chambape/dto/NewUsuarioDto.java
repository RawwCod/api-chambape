package com.ucsm.proyecto.chambape.dto;

import com.ucsm.proyecto.chambape.model.Tipo;

public record NewUsuarioDto(
    String nombre,
    String apellido,
    String correo,
    String contrasena,
    String telefono,
    String direccion,
    Tipo tipo
) {
    
}
