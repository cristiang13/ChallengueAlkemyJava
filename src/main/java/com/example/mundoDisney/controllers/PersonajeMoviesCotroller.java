package com.example.mundoDisney.controllers;



import java.util.*;

import com.example.mundoDisney.models.PeliculasSeriesModel;
import com.example.mundoDisney.models.PersonajeModel;
import com.example.mundoDisney.models.PersonajeMoviesModel;
import com.example.mundoDisney.models.PersonajeMoviesPK;
import com.example.mundoDisney.repositories.PeliculasSeriesRepository;
import com.example.mundoDisney.repositories.PersonajeMoviesRepository;
import com.example.mundoDisney.repositories.PersonajeRepository;
import com.example.mundoDisney.services.PeliculasSeriesService;
import com.example.mundoDisney.services.PersonajeMoviesService;
import com.example.mundoDisney.services.PersonajeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personajesMovies")
public class PersonajeMoviesCotroller {
 
    @Autowired
   PeliculasSeriesRepository peliculasSeriesRepository;

   
    @Autowired
    PersonajeRepository personajeRepository;

    @Autowired
    PersonajeMoviesRepository personajeMoviesRepository;


    @Autowired
    PersonajeMoviesService personajeMoviesService;

    @Autowired
    PeliculasSeriesService peliculasSeriesService;

    @Autowired
    PersonajeService personajeService;

    @GetMapping("/personajeMovie")
	public void ingresarPersonajeMovies(@RequestParam(name="movie", required=false, defaultValue="null") String tituloMovie, @RequestParam(name="personaje", required=false, defaultValue="null") String personaje) {

       ArrayList<PersonajeModel> actor =personajeRepository.findByNombre(personaje);

       ArrayList<PeliculasSeriesModel> movie= peliculasSeriesRepository.findByTitulo(tituloMovie);

       PersonajeMoviesModel pm=new PersonajeMoviesModel();
       PersonajeMoviesPK pmk=new  PersonajeMoviesPK();
       pmk.setPersonaje(actor.get(0));
       pmk.setPeliculasSeries(movie.get(0));
       pm.setPersonajeMoviesPK(pmk);

        personajeMoviesRepository.save(pm);
        
        
	}

  @GetMapping("/detallePersonaje")
  public Map<String,Object>obtenerPorPersonaje(@RequestParam("personaje") String personaje){
    List<PeliculasSeriesModel> peliculasSeries= this.personajeMoviesService.obtenerMoviesPorPersonaje(personaje);
    ArrayList<PersonajeModel> actor= this.personajeService.obtenerPorNombre(personaje);
    Map<String,Object>parm=new LinkedHashMap<String, Object>();
    parm.put("Persoanje", actor);
    parm.put("Peliculas o Series", peliculasSeries);
    return parm;     
  }

  @GetMapping("/detalleMovie")
  public Map<String, Object> obtenerPorMovie(@RequestParam("movie") String movie){
    ArrayList<PeliculasSeriesModel> peliculaSerie=this.peliculasSeriesService.obtenerPorTitulo(movie); 
    List<PersonajeModel> personaje=this.personajeMoviesService.obtenerPersonajePorPeliculaSerie(movie);
    Map<String,Object>parm=new LinkedHashMap<String, Object>();
    parm.put("pelicula o serie", peliculaSerie);
    parm.put("personajes", personaje);
    return parm;     
  }

  @DeleteMapping(path = "{id}")
  public  String eliminarPorId(@PathVariable("id")Long id) {  
    boolean ok= this.personajeMoviesService.eliminarPersonajeMovie(id);
      if(ok){
          return "se elimino el personaje id"+id;
      }else{
          return "no pudo eliminar el personaje con id"+id;
      }
  }

   
    
}
