package com.ucsm.proyecto.chambape.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.CambioEstadoSolicitudDto;
import com.ucsm.proyecto.chambape.dto.ResenaDto;
import com.ucsm.proyecto.chambape.dto.SolicitudServicioDto;
import com.ucsm.proyecto.chambape.model.EstadoSolicitud;
import com.ucsm.proyecto.chambape.model.SolicitudServicio;
import com.ucsm.proyecto.chambape.model.Usuario;
import com.ucsm.proyecto.chambape.model.UsuarioServicio;
import com.ucsm.proyecto.chambape.repository.SolicitudServicioRepository;

@Service
public class SolicitudServicioService {
    
    @Autowired
    private SolicitudServicioRepository solicitudServicioRepository;
    @Autowired
    private UsuarioServicioService usuarioServicioService;
    @Autowired
    private UsuarioService usuarioService;

    public void saveSolicitudServicio(SolicitudServicioDto solicitudServicioDto){
        SolicitudServicio solicitudServicio=new SolicitudServicio();
        solicitudServicio.setDescripcion(solicitudServicioDto.descripcion());
        UsuarioServicio usuarioServicio=usuarioServicioService.getUsuarioServicio(solicitudServicioDto.idUsuarioServicio());
        Usuario cliente=usuarioService.getUsuario(solicitudServicioDto.idCliente()).get();
        solicitudServicio.setUsuarioServicio(usuarioServicio);
        solicitudServicio.setCliente(cliente);
        solicitudServicio.setEstadoSolicitud(EstadoSolicitud.Pendiente);
        solicitudServicioRepository.save(solicitudServicio);
    }

    public SolicitudServicio getSolicitudServicio(Integer id){
        SolicitudServicio solicitudServicio=solicitudServicioRepository.findById(id).get();
        if(solicitudServicio==null){
            return null;
        }
        return solicitudServicio;
    }

    public void deleteSolicitudServicio(Integer id){
        SolicitudServicio solicitudServicio=solicitudServicioRepository.findById(id).get();
        solicitudServicioRepository.delete(solicitudServicio);
    }

    public void changeStatus(CambioEstadoSolicitudDto cambioEstadoSolicitudDto){

        SolicitudServicio solicitudServicio=solicitudServicioRepository.findById(cambioEstadoSolicitudDto.idSolicitudServicio()).get();
        solicitudServicio.setEstadoSolicitud(cambioEstadoSolicitudDto.estado());
        solicitudServicioRepository.save(solicitudServicio);
    }

    public ArrayList<UsuarioServicio> getUsuarioServicioByCliente(Integer idCliente){
        //falta validar que el metodo se genere correctamete
        ArrayList<SolicitudServicio> solicitudServicios=solicitudServicioRepository.findByClienteId(idCliente);
        ArrayList<UsuarioServicio> usuarioServicios=new ArrayList<UsuarioServicio>();
        for(SolicitudServicio solicitudServicio:solicitudServicios){
            usuarioServicios.add(solicitudServicio.getUsuarioServicio());
        }
        return usuarioServicios;
    }

    public ArrayList<SolicitudServicio> getSolicitudServicioByUsuario(Integer idUsuario){
        //falta validar que el metodo se genere correctamete
        ArrayList<UsuarioServicio> usuarioServicios=usuarioServicioService.getUsuarioServicioByUsuario(idUsuario);
        ArrayList<SolicitudServicio> solicitudServicios=new ArrayList<SolicitudServicio>();
        for(UsuarioServicio usuarioServicio:usuarioServicios){
            //falta validar que el metodo se genere correctamete
            solicitudServicios.addAll(solicitudServicioRepository.findByUsuarioServicioId(usuarioServicio.getId()));
        }
        return solicitudServicios;
    }
    
    public ArrayList<SolicitudServicio>getSolicitudServicioByCliente(Integer idCliente){
        //falta validar que el metodo se genere correctamete
        ArrayList<SolicitudServicio> solicitudServicios=solicitudServicioRepository.findByClienteId(idCliente);
        return solicitudServicios;
    }

    public ArrayList<ResenaDto> getResenaByCliente(Integer idCliente){
        //falta validar que el metodo se genere correctamete
        ArrayList<SolicitudServicio> solicitudServicios=solicitudServicioRepository.findByClienteId(idCliente);
        ArrayList<ResenaDto> resenas=new ArrayList<ResenaDto>();
        for(SolicitudServicio solicitudServicio:solicitudServicios){
            if(solicitudServicio.getResena()!=null){
                ResenaDto resena=new ResenaDto(
                    solicitudServicio.getId(),
                    solicitudServicio.getUsuarioServicio().getUsuario().getId(),
                    solicitudServicio.getResena(),
                    solicitudServicio.getUsuarioServicio().getUsuario().getNombre()+ " "+
                    solicitudServicio.getUsuarioServicio().getUsuario().getApellido(),
                    solicitudServicio.getFechaSolicitud(),
                    solicitudServicio.getUsuarioServicio().getCalificacion()
                );
                resenas.add(resena);
            }
        }
        return resenas;
    }
    

}
