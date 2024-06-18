package com.ucsm.proyecto.chambape.service;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.DepartamentoDto;
import com.ucsm.proyecto.chambape.model.DepartamentoCober;
import com.ucsm.proyecto.chambape.model.Estado;
import com.ucsm.proyecto.chambape.repository.DepartamentoCoberRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoCoberRepository departamentoRepository;

    public void saveDepartamento(DepartamentoDto departamentoDto){
        DepartamentoCober departamento=new DepartamentoCober();
        departamento.setNombre(departamentoDto.nombre());
        departamento.setEstado(Estado.Activo);
        departamentoRepository.save(departamento);
    }

    public DepartamentoCober getDepartamento(Integer id){
        DepartamentoCober departamento=departamentoRepository.findById(id).get();
        if(departamento.getEstado()==Estado.Inactivo){
            return null;
        }
        return departamento;
    }

    public void deleteDepartamento(Integer id){
        DepartamentoCober departamento=departamentoRepository.findById(id).get();
        departamento.setEstado(Estado.Inactivo);
        departamentoRepository.save(departamento);
    }

    public ArrayList<DepartamentoCober> getAllDepartamento(){
        ArrayList<DepartamentoCober> departamentos=new ArrayList<DepartamentoCober>(departamentoRepository.findAll());
        return departamentos;
    }
}
