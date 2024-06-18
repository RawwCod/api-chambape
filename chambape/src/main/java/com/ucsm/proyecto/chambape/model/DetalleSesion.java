package com.ucsm.proyecto.chambape.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "detalle_sesion")
@Data
public class DetalleSesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_increment")
    Integer id;

    @Column(unique=true)
    String nombreUsuario;

    String contrasena;

    @OneToOne
    @JoinColumn(name = "id-usuario")
    Usuario usuario;
}
