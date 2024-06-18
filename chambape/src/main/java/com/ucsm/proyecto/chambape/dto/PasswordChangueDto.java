package com.ucsm.proyecto.chambape.dto;

public record PasswordChangueDto(
    String correo,
    String password_old,
    String password_new
) {

}
