package com.ucsm.proyecto.chambape.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.ServicioDistritoDto;
import com.ucsm.proyecto.chambape.model.Distrito;
import com.ucsm.proyecto.chambape.model.Servicio;
import com.ucsm.proyecto.chambape.model.ServicioDistrito;
import com.ucsm.proyecto.chambape.repository.DistritoRepository;
import com.ucsm.proyecto.chambape.repository.ServicioDistritoRepository;
import com.ucsm.proyecto.chambape.repository.ServicioRepository;

@Service
public class ServicioDistritoService {
    
    @Autowired
    private ServicioDistritoRepository servicioDistritoRepository;
    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private DistritoRepository distritoRepository;

    public void saveServicioDistrito(ServicioDistritoDto servicioDistritoDto){
        Servicio servicio=servicioRepository.findById(servicioDistritoDto.idServicio()).get();
        Distrito distrito=distritoRepository.findById(servicioDistritoDto.idDistrito()).get();
        ServicioDistrito servicioDistrito=new ServicioDistrito();
        servicioDistrito.setServicio(servicio);
        servicioDistrito.setDistrito(distrito);
        servicioDistritoRepository.save(servicioDistrito);
    }

    public ServicioDistrito getServicioDistrito(Integer id){
        ServicioDistrito servicioDistrito=servicioDistritoRepository.findById(id).get();
        if(servicioDistrito==null){
            return null;
        }
        return servicioDistrito;
    }

    public void deleteServicioDistrito(Integer id){
        ServicioDistrito servicioDistrito=servicioDistritoRepository.findById(id).get();
        servicioDistritoRepository.delete(servicioDistrito);
    }

    public ArrayList<ServicioDistrito> getAllServicioDistrito(){
        ArrayList<ServicioDistrito> servicioDistritos=new ArrayList<ServicioDistrito>(servicioDistritoRepository.findAll());
        return servicioDistritos;
    }
}
