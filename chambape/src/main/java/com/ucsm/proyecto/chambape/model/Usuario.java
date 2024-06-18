package com.ucsm.proyecto.chambape.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nombre;

    String apellido;

    @Column(unique=true)
    String correo;

    String telefono;

    //calificacion es del 1 al 5
    Integer calificacion;

    String numCuenta;
    
    String direccion;

    @Enumerated(EnumType.STRING)
    Tipo tipo;

    @Enumerated(EnumType.STRING)
    Estado estado;
}
