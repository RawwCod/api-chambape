package com.ucsm.proyecto.chambape.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.ServicioDto;
import com.ucsm.proyecto.chambape.dto.UsuarioServicioDto;
import com.ucsm.proyecto.chambape.model.Estado;
import com.ucsm.proyecto.chambape.model.Servicio;
import com.ucsm.proyecto.chambape.model.Subcategoria;
import com.ucsm.proyecto.chambape.model.UsuarioServicio;
import com.ucsm.proyecto.chambape.repository.ServicioRepository;
import com.ucsm.proyecto.chambape.repository.SubcategoriaRepository;

@Service
public class ServicioService {
    
    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private UsuarioServicioService usuarioServicioService;

    public void saveServicio(ServicioDto servicioDto){
        Servicio servicio=new Servicio();
        servicio.setNombre(servicioDto.nombre());
        servicio.setDescripcion(servicioDto.descripcion());
        servicio.setPrecio(servicioDto.precio());
        servicio.setEstado(Estado.Activo);
        servicio.setImagen(servicioDto.imagen());
        Subcategoria subcategoria=subcategoriaRepository.findById(servicioDto.idSubCategoria()).get();
        servicio.setSubcategoria(subcategoria);
        servicioRepository.save(servicio);

        
        usuarioServicioService.saveUsuarioServicio(
            //la asignacion del servicio.getId() podria ser incorrecta 
            new UsuarioServicioDto(
                servicioDto.idProveedor(), 
                servicio.getId(),
                servicioDto.estado(),
                Integer.valueOf(0),
                servicioDto.precio(),
                servicioDto.imagen(),
                servicioDto.descripcion(),
                servicioDto.unidadCobro(),
                servicioDto.pagoAnticipado(),
                servicioDto.diasDisponibles(),
                servicioDto.horasDisponibles()
                )
        );

        System.out.println(servicio);
    }

    public Servicio getServicio(Integer id){
        Servicio servicio=servicioRepository.findById(id).get();
        if(servicio.getEstado()==Estado.Inactivo){
            return null;
        }
        return servicio;
    }

    public void deleteServicio(Integer id){
        Servicio servicio=servicioRepository.findById(id).get();
        servicio.setEstado(Estado.Inactivo);
        servicioRepository.save(servicio);
    }

    public ArrayList<Servicio> getAllServicio(){
        ArrayList<Servicio> servicios=new ArrayList<Servicio>(servicioRepository.findAll());
        return servicios;
    }
}
