/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lanister.biblioteca.controller;

import com.lanister.biblioteca.dto.AutorDTO;
import com.lanister.biblioteca.model.Autor;
import com.lanister.biblioteca.service.AutorService;
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
@RequestMapping("/api/v1/biblioteca/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping()
    public ResponseEntity<AutorDTO> save(@RequestBody AutorDTO autor) {
        return new ResponseEntity<>(autorService.save(autor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> findAll() {
        return new ResponseEntity<>(autorService.findAll(), HttpStatus.OK);
    }
    
   

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> findById(@PathVariable Integer id) {
        AutorDTO autor = autorService.findById(id);

        if (autor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {

        HttpStatus estado = HttpStatus.OK;
        try {
            autorService.deleteById(id);
        } catch (Exception e) {
            estado = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(estado);

    }
}
