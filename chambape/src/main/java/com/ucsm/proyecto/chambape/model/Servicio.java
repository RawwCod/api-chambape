package com.ucsm.proyecto.chambape.model;

import java.io.File;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "servicio")
@Data
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nombre;

    String descripcion;

    //faltan parametros para la imagen
    String imagen;

    @Enumerated(EnumType.STRING)    
    Estado estado;

    Double precio;

    @ManyToOne
    @JoinColumn(name = "id-subcategoria")
    Subcategoria subcategoria;

}
