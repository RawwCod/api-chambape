package com.ucsm.proyecto.chambape.model;

import java.io.File;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nombre;

    //faltan parametros para la imagen
    File imagen;

    //icono
    File icono;

    @Enumerated(EnumType.STRING)
    Estado estado;

    String descripcion;
}
