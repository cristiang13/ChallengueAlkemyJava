package com.example.mundoDisney.controllers;

import java.util.ArrayList;

import com.example.mundoDisney.models.PersonajeModel;
import com.example.mundoDisney.services.PersonajeMoviesService;
import com.example.mundoDisney.services.PersonajeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
    
    @Autowired
    PersonajeService personajeService;

    @Autowired
    PersonajeMoviesService personajeMoviesService;

    @GetMapping
    public ArrayList<PersonajeModel> obtenerPersonaje(){
        return personajeService.obtenerPersonaje();
    }

    @PostMapping
    public PersonajeModel guardarPersonaje(@RequestBody PersonajeModel personaje){
        return this.personajeService.guardarPersonaje(personaje);
    }

    @GetMapping("/name")
    public ArrayList<PersonajeModel>obtenerPorNombre(@RequestParam("nombre") String nombre){
        return this.personajeService.obtenerPorNombre(nombre);
    }

    @GetMapping("/age")
    public ArrayList<PersonajeModel>obtenerPorEdad(@RequestParam("edad") Integer edad){
        return this.personajeService.obtenerPorEdad(edad);
    }

    @DeleteMapping(path = "{id}")
    public  String eliminarPorId(@PathVariable("id")Long id) {
        boolean okPM= this.personajeMoviesService.eliminarPersonajeMovie(id);
        boolean ok= this.personajeService.eliminarPersonaje(id);
        if(okPM && ok ){
            return "se elimino el personaje id"+id;
        }else{
            return "no pudo eliminar el personaje con id"+id;
        }
    }
    

}
