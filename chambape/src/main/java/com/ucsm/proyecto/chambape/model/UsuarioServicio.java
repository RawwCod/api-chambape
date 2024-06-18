package com.ucsm.proyecto.chambape.model;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.cglib.core.Local;

import com.ucsm.proyecto.chambape.dto.UnidadCobro;

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
@Table(name = "usuario_servicio")
@Data
public class UsuarioServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Boolean estado;

    Integer calificacion;

    Float precio;

    //foto del servicio
    File foto;

    String descripcion;

    @Enumerated(EnumType.STRING)
    UnidadCobro unidadCobro;

    Boolean pagoAnticipado;

    //franjas horarias dias y horas de atencion
    ArrayList<LocalDate> dias;
    ArrayList<LocalTime> horasInicio;

    @ManyToOne
    @JoinColumn(name = "id-usuario")
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id-servicio")
    Servicio servicio;
}
