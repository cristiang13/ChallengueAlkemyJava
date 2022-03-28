package com.example.mundoDisney.controllers;

import java.util.ArrayList;
import java.util.Map;

import com.example.mundoDisney.models.PeliculasSeriesModel;
import com.example.mundoDisney.services.PeliculasSeriesService;
import com.example.mundoDisney.services.PersonajeMoviesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movies")
public class PeliculasSeriesController {
    
    @Autowired
    PeliculasSeriesService peliculasSeriesService;

    @Autowired
    PersonajeMoviesService personajeMoviesService;

    @GetMapping
    public ArrayList<PeliculasSeriesModel> obtenerPeliculasSeries(){
        return peliculasSeriesService.obtenerPeliculasSeries();
    }

    @PostMapping
    public PeliculasSeriesModel guardarPeliculasSeries(@RequestBody Map<String, String> peliculasSeries){
        return this.peliculasSeriesService.guardarPeliculasSeries(peliculasSeries);
    }

  
    @GetMapping("/name")
    public ArrayList<PeliculasSeriesModel> obtenerPorTitulo(@RequestParam("titulo") String titulo){
        return this.peliculasSeriesService.obtenerPorTitulo(titulo);
    }

    @GetMapping("/genero")
    public ArrayList<PeliculasSeriesModel> obtenerPorGenero(@RequestParam("idGenero") Long id){
        return this.peliculasSeriesService.obtenerPorGenero(id);
    }


    @PutMapping()
    public PeliculasSeriesModel update(@RequestBody PeliculasSeriesModel peliculasSeries){
        return this.peliculasSeriesService.actualizar(peliculasSeries);
    }


    @DeleteMapping(path = "{id}")
    public  String eliminarPorId(@PathVariable("id")Long id) {
        boolean okPM= this.personajeMoviesService.eliminarPersonajeMoviePorMovie(id);
        boolean ok= this.peliculasSeriesService.eliminarPeliculasSeries(id);
        if(okPM && ok ){
            return "se elimino la peliculas o serie con  id"+id;
        }else{
            return "no pudo eliminar la pelicula o serie id"+id;
        }
    }




}
