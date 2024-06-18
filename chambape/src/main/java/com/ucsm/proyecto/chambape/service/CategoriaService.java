package com.ucsm.proyecto.chambape.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.CategoriaDto;
import com.ucsm.proyecto.chambape.model.Categoria;
import com.ucsm.proyecto.chambape.model.Estado;
import com.ucsm.proyecto.chambape.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void saveCategoria(CategoriaDto categoriaDto){
        Categoria categoria=new Categoria();
        categoria.setNombre(categoriaDto.nombre());
        categoria.setDescripcion(categoriaDto.descripcion());
        categoria.setEstado(Estado.Activo);
        categoria.setImagen(categoriaDto.imagen());
        categoriaRepository.save(categoria);
    }

    public Categoria getCategoria(Integer id){
        Categoria categoria=categoriaRepository.findById(id).get();
        if(categoria==null){
            return null;
        }
        if(categoria.getEstado()==Estado.Inactivo){
            return null;
        }
        return categoria;
    }

    public void deleteCategoria(Integer id){
        Categoria categoria=categoriaRepository.findById(id).get();
        categoria.setEstado(Estado.Inactivo);
        categoriaRepository.save(categoria);
    }

    public ArrayList<Categoria> getAllCategoria(){
        ArrayList<Categoria> categorias=new ArrayList<Categoria>(categoriaRepository.findAll());
        return categorias;
    }
}
