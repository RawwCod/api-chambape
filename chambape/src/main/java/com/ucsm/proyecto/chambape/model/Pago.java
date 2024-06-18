package com.ucsm.proyecto.chambape.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pago")
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Double precioTotal;

    Double precioAdelantado;

    Double precioRestante;

    @Enumerated(EnumType.STRING)
    EstadoPago estadoPago;

    @Enumerated(EnumType.STRING)
    MetodoPago metodoPago;

    @OneToOne
    @PrimaryKeyJoinColumn
    SolicitudServicio solicitudServicio;
}
