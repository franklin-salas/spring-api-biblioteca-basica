/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lanister.biblioteca.controller;


import com.lanister.biblioteca.dto.LibroDTO;
import com.lanister.biblioteca.service.AutorService;
import com.lanister.biblioteca.service.LibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author frank
 */
@RestController
@RequestMapping("/api/v1/biblioteca/libros")
public class LibroController {

 
    @Autowired
    private LibroService libroService;

    @PostMapping()
    public ResponseEntity<LibroDTO> save(@RequestBody LibroDTO libro) {
        try {
        return new ResponseEntity<>(libroService.save(libro), HttpStatus.CREATED);    
        } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping
    public ResponseEntity<List<LibroDTO>> findAll() {
        return new ResponseEntity<>(libroService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> findById(@PathVariable Integer id) {
        LibroDTO libro = libroService.findById(id);

        if (libro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(libro, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {

        HttpStatus estado = HttpStatus.OK;
        try {
            libroService.deleteById(id);
        } catch (Exception e) {
            estado = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(estado);

    }
}
