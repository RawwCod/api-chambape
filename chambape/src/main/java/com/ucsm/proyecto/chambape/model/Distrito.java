package com.ucsm.proyecto.chambape.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "distrito")
@Data
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nombre;

    @ManyToOne
    @JoinColumn(name = "id-departamento")
    DepartamentoCober departamentoCober;

    // @ManyToMany
    // @JoinColumn(name = "id")
    // Servicio servicio;
}
