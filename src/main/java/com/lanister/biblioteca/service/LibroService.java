/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lanister.biblioteca.service;

import com.lanister.biblioteca.dto.AutorDTO;
import com.lanister.biblioteca.dto.LibroDTO;
import com.lanister.biblioteca.model.Libro;
import com.lanister.biblioteca.repository.IAutorRepository;
import com.lanister.biblioteca.repository.ILibroRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author frank
 */
@Service
public class LibroService {
    
    @Autowired
    private ILibroRepository repository;
    
    @Autowired
    private AutorService autorService;
    
    public LibroDTO save(LibroDTO libro){  
        
        AutorDTO autor = autorService.findById(libro.getIdAutor());
        libro.setAutor(autor);
        return crearLibroDTO(repository.save(crearLibro(libro)));
    } 
    
    public  List<LibroDTO> findAll(){
        return  crearLibrosDTO(repository.findAll());
    }
    
    public LibroDTO findById(Integer id) {
        Optional<Libro> optionalLibro = repository.findById(id);

        if (optionalLibro.isPresent()) {
            return crearLibroDTO(optionalLibro.get());
        }

        return null;

    }
     public void deleteById(Integer id) {
        repository.deleteById(id);

    }
    public Libro crearLibro(LibroDTO libro){
        return new Libro(libro);
    }
    public LibroDTO crearLibroDTO(Libro libro){
        return new LibroDTO(libro);
    }
    
    public List<LibroDTO> crearLibrosDTO(List<Libro> libros){
        List<LibroDTO> librosDTO = new ArrayList<>();
        libros.stream().forEach(
        
                li-> {
                    librosDTO.add(crearLibroDTO(li));
                }
        );
        
        return librosDTO;
    }

  
}
