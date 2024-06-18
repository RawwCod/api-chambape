package com.ucsm.proyecto.chambape.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.DistritoDto;
import com.ucsm.proyecto.chambape.model.DepartamentoCober;
import com.ucsm.proyecto.chambape.model.Distrito;
import com.ucsm.proyecto.chambape.repository.DistritoRepository;

@Service
public class DistritoService {
    
    @Autowired
    private DistritoRepository distritoRepository;
    @Autowired
    private DepartamentoService departamentoService;

    public void saveDistrito(DistritoDto distritoDto){
        Distrito distrito=new Distrito();
        distrito.setNombre(distritoDto.nombre());
        DepartamentoCober departamento=departamentoService.getDepartamento(distritoDto.idDepartamento());
        distrito.setDepartamentoCober(departamento);;
        distritoRepository.save(distrito);
    }

    public Distrito getDistrito(Integer id){
        Distrito distrito=distritoRepository.findById(id).get();
        if(distrito==null){
            return null;
        }
        return distrito;
    }

    public void deleteDistrito(Integer id){
        Distrito distrito=distritoRepository.findById(id).get();
        distritoRepository.delete(distrito);
    }

    public ArrayList<Distrito> getAllDistrito(){
        ArrayList<Distrito> distritos=new ArrayList<Distrito>(distritoRepository.findAll());
        return distritos;
    }

}
