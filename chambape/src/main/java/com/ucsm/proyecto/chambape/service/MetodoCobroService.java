package com.ucsm.proyecto.chambape.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.MetodoCobroDto;
import com.ucsm.proyecto.chambape.model.MetodoCobro;
import com.ucsm.proyecto.chambape.repository.MetodoCobroRepository;

@Service
public class MetodoCobroService {
    
    @Autowired
    private MetodoCobroRepository metodoCobroRepository;

    public void saveMetodoCobro(MetodoCobroDto metodoCobroDto){
        MetodoCobro metodoCobro=new MetodoCobro();
        metodoCobro.setNombre(metodoCobroDto.nombre());
        metodoCobro.setEstado(metodoCobroDto.estado());
        metodoCobroRepository.save(metodoCobro);
    }

    public ArrayList<MetodoCobro> getAllMetodoCobro(){
        ArrayList<MetodoCobro> metodoCobros=new ArrayList<MetodoCobro>(metodoCobroRepository.findAll());
        return metodoCobros;
    }
}
