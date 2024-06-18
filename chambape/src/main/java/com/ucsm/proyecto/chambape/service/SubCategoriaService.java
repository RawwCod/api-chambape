package com.ucsm.proyecto.chambape.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.SubCategoriaDto;
import com.ucsm.proyecto.chambape.model.Categoria;
import com.ucsm.proyecto.chambape.model.Estado;
import com.ucsm.proyecto.chambape.model.Subcategoria;
import com.ucsm.proyecto.chambape.repository.CategoriaRepository;
import com.ucsm.proyecto.chambape.repository.SubcategoriaRepository;

@Service
public class SubCategoriaService {
    
    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void saveSubCategoria(SubCategoriaDto subCategoriaDto){
        Subcategoria subCategoria=new Subcategoria();
        subCategoria.setNombre(subCategoriaDto.nombre());
        subCategoria.setDescripcion(subCategoriaDto.descripcion());
        subCategoria.setEstado(Estado.Activo);
        Categoria categoria=categoriaRepository.findById(subCategoriaDto.idCategoria()).get();
        subCategoria.setCategoria(categoria);
        subcategoriaRepository.save(subCategoria);
    }

    public Subcategoria getSubCategoria(Integer id){
        Subcategoria subCategoria=subcategoriaRepository.findById(id).get();
        if(subCategoria.getEstado()==Estado.Inactivo){
            return null;
        }
        return subCategoria;
    }

    public void deleteSubCategoria(Integer id){
        Subcategoria subCategoria=subcategoriaRepository.findById(id).get();
        subCategoria.setEstado(Estado.Inactivo);
        subcategoriaRepository.save(subCategoria);
    }

    public ArrayList<Subcategoria> getAllSubCategoria(){
        ArrayList<Subcategoria> subCategorias=new ArrayList<Subcategoria>(subcategoriaRepository.findAll());
        return subCategorias;
    }

    public ArrayList<Subcategoria> getSubCategoriaByCategoria(Integer id){
        Categoria categoria=categoriaRepository.findById(id).get();
        ArrayList<Subcategoria> subCategorias=new ArrayList<Subcategoria>(subcategoriaRepository.findByCategoria(categoria));
        return subCategorias;
    }
}
