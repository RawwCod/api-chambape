package com.ucsm.proyecto.chambape.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.ResponsePagoDto;
import com.ucsm.proyecto.chambape.model.Pago;
import com.ucsm.proyecto.chambape.model.SolicitudServicio;
import com.ucsm.proyecto.chambape.repository.PagoRepository;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private UsuarioServicioService usuarioServicioService;
    @Autowired
    private SolicitudServicioService solicitudServicioService;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public ArrayList<ResponsePagoDto> getPagosByUsuario(Integer id) {
        ArrayList<ResponsePagoDto> pagos = new ArrayList<ResponsePagoDto>();
        ArrayList<SolicitudServicio> solicitudes=solicitudServicioService.getSolicitudServicioByUsuario(id);
        for (SolicitudServicio solicitud : solicitudes) {
            Pago pago = pagoRepository.findBySolicitudServicio(solicitud);
            if (pago != null) {
                solicitud.getCliente().getId();
                solicitud.getCliente().getNombre();

                ResponsePagoDto responsePagoDto = new ResponsePagoDto(
                    pago.getId(),
                    pago.getPrecioTotal(),
                    pago.getPrecioAdelantado(),
                    pago.getPrecioRestante(),
                    pago.getEstadoPago(),
                    pago.getMetodoPago(),
                    solicitud.getId(),
                    solicitud.getCliente().getId(),
                    solicitud.getCliente().getNombre()+solicitud.getCliente().getApellido()
                );
                pagos.add(responsePagoDto);
            }
        }
        return pagos;
    }
}
