package com.ucsm.proyecto.chambape.dto;

import com.ucsm.proyecto.chambape.model.EstadoPago;
import com.ucsm.proyecto.chambape.model.MetodoPago;

public record ResponsePagoDto(

    Integer id_pago,
    Double precioTotal,
    Double precioAdelantado,
    Double precioRestante,
    
    EstadoPago estadoPago,
    MetodoPago metodoPago,

    Integer id_solicitud_servicio,
    Integer id_cliente,
    String nombre_cliente
) {
    
}
