package com.ucsm.proyecto.chambape.model;

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
@Table(name = "subcategoria")
@Data
public class Subcategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nombre;

    @Enumerated(EnumType.STRING)
    Estado estado;

    String descripcion;

    @ManyToOne
    @JoinColumn(name = "id-categoria")
    Categoria categoria;
}
