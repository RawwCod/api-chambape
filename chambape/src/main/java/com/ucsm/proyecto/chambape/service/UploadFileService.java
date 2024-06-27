package com.ucsm.proyecto.chambape.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.File;

import java.util.UUID;

@Service
public class UploadFileService {
    private final static String UPLOAD_FOLDER = "chambape/uploads";

    public Resource load(String filename) throws MalformedURLException {
        Path path = getPath(filename);
        Resource resource = new UrlResource(path.toUri());  

        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("Fallo cargando imagen!");
        }
    }

    public String copy(MultipartFile file) throws IOException {
		if(file.isEmpty()) {
			System.out.println("Error al cargar imagen! El archivo está vacío.");
			throw new IOException("El archivo está vacío.");
		}
		System.out.println("El nombre del archivo es: " + file.getOriginalFilename());
		try{
		String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		Path rootPath = getPath(uniqueFilename);
		System.out.println("rootPath: " + rootPath);
		Files.copy(file.getInputStream(), rootPath);
		return uniqueFilename;
		} catch (IOException e) {
			System.out.println("ERRORRRRR " + e.getMessage());
			throw new IOException("Error al cargar imagen! " + e.getMessage());
		}
		//Path rootPath = getPath(uniqueFilename);
		//Files.copy(file.getInputStream(), rootPath);
		//return "uniqueFilename";
	}

    public boolean delete(String filename) {
		Path rootPath = getPath(filename);
		File file = rootPath.toFile();
		if(file.exists() && file.canRead()) {
			if(file.delete()) {
				return true;
			}
		}
		return false;
	}

    public Path getPath(String filename) {
		return Paths.get(UPLOAD_FOLDER).resolve(filename).toAbsolutePath();
	}
}
