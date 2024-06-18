package com.ucsm.proyecto.chambape.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
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
@Table(name = "solicitud_servicio")
@Data
public class SolicitudServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    LocalDate fechaSolicitud;

    String descripcion;

    Integer cantidadServicio;

    @Enumerated(EnumType.STRING)
    EstadoSolicitud estadoSolicitud;

    @ManyToOne
    @JoinColumn(name = "id-usuarioServicio")
    UsuarioServicio usuarioServicio;

    String direccion;

    //fecha del servicio a prestar
    LocalDate fechaServicio;
    LocalTime horaServicio;

    String resena;

    @ManyToOne
    @JoinColumn(name = "id-cliente")
    Usuario cliente;
}
