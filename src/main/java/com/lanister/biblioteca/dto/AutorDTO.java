/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lanister.biblioteca.dto;



import com.lanister.biblioteca.model.Autor;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author frank
 */
@Data
@NoArgsConstructor


public class AutorDTO {
   
    private Integer id;
    private String nombre;
    private String apellidos;
    private String telefono;
    //private List<LibroDTO> libros;

    public  AutorDTO(Autor autor){
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.apellidos = autor.getApellidos();
        this.telefono = autor.getTelefono();
        // this.libros = new ArrayList<>();
       /* autor.getLibros().forEach(
                libro -> libros.add(new LibroDTO(libro))
        );*/
    }
}

