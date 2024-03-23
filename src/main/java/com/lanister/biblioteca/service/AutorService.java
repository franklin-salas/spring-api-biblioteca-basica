/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lanister.biblioteca.service;

import com.lanister.biblioteca.dto.AutorDTO;
import com.lanister.biblioteca.model.Autor;
import com.lanister.biblioteca.repository.IAutorRepository;
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
public class AutorService {

    @Autowired
    private IAutorRepository repository;

    public AutorDTO save(AutorDTO autor) {

        return crearAutorDTO(repository.save(crearAutor(autor)));
    }

    public List<AutorDTO> findAll() {
        return crearAutoresDTO(repository.findAll());
    }

    
    public AutorDTO findById(Integer id) {

        Optional<Autor> optionalAutor = repository.findById(id);

        if (optionalAutor.isPresent()) {
            return crearAutorDTO(optionalAutor.get());
        }

        return null;

    }

    public void deleteById(Integer id) {
        repository.deleteById(id);

    }

    public Autor crearAutor(AutorDTO autor) {
        return new Autor(autor);
    }

    public AutorDTO crearAutorDTO(Autor autor) {
        return new AutorDTO(autor);
    }

    public List<AutorDTO> crearAutoresDTO(List<Autor> autores) {
        
        System.out.println(autores);
        List<AutorDTO> autoresDTO = new ArrayList<>();
        autores.stream().forEach(
                autor -> {
                    autoresDTO.add(crearAutorDTO(autor));
                }
        );

        return autoresDTO;
    }

}
