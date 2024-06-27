package com.ucsm.proyecto.chambape.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ucsm.proyecto.chambape.service.UploadFileService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping(path = "/imagenes")
public class ImageController {
    
    @Autowired
    private UploadFileService uploadFileService;

    @GetMapping(path = "/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        try {
            Resource resource = uploadFileService.load(filename);
            byte[] imageContent = Files.readAllBytes(resource.getFile().toPath());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Ajusta según el tipo de imagen
            return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error al cargar imagen! " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
        public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        // Aquí puedes implementar la lógica para manejar la carga del archivo
        // Por ejemplo, guardar el archivo en el servidor o procesarlo de alguna manera
        try {
            return uploadFileService.copy(file);
        }
        catch(IOException e){
            System.out.println("Error al cargar imagen! " + e.getMessage());
            return "Error al cargar imagen! " + e.getMessage();
        } 
        catch (Exception e) {
            // En caso de error, puedes manejar la excepción aquí
            System.out.println("Error "+ e.getMessage());
            return "Error al cargar el archivo: " + e.getMessage();
        }
        // Retorna una respuesta indicando el éxito de la operación
        //return "Archivo " + file.getOriginalFilename() + " cargado con éxito";
    }
    
}
