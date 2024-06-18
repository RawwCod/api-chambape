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
@Table(name = "servicio_distrito")
@Data
public class ServicioDistrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "id-servicio")
    Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "id-destrito")
    Distrito distrito;
}
