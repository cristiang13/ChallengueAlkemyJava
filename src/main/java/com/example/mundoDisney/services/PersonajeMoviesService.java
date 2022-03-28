package com.example.mundoDisney.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.mundoDisney.models.PeliculasSeriesModel;
import com.example.mundoDisney.models.PersonajeModel;
import com.example.mundoDisney.repositories.PeliculasSeriesRepository;
import com.example.mundoDisney.repositories.PersonajeMoviesRepository;
import com.example.mundoDisney.repositories.PersonajeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeMoviesService {
    @Autowired
    PersonajeMoviesRepository personajeMoviesRepository;

    @Autowired
    PersonajeRepository personajeRepository;

    @Autowired
    PeliculasSeriesRepository peliculasSeriesRepository;

    public List<PeliculasSeriesModel>obtenerMoviesPorPersonaje(String nombre){
        ArrayList<PersonajeModel> actor= personajeRepository.findByNombre(nombre);
       return this.personajeMoviesRepository.findByPersonajeMoviesPKPersonaje(actor.get(0));
    }

    public List<PersonajeModel> obtenerPersonajePorPeliculaSerie(String titulo){
        ArrayList<PeliculasSeriesModel> movie= peliculasSeriesRepository.findByTitulo(titulo);
        return this.personajeMoviesRepository.findByPersonajeMoviesPKPeliculasSeries(movie.get(0));        
    }

    public boolean eliminarPersonajeMovie(Long id){
      try {
        Optional<PersonajeModel> actor= personajeRepository.findById(id);
        List<PeliculasSeriesModel> peliculasSeries= this.personajeMoviesRepository.findByPersonajeMoviesPKPersonaje(actor.get());
        int size=peliculasSeries.size();
        for(int i=0; i < size; i++){
          Long id_actor= actor.get().getId();
          Long id_peliculaSerie=peliculasSeries.get(i).getId();
          personajeMoviesRepository.deleteByPersonajeMoviesPK(id_actor,id_peliculaSerie);
        }
        
         
          return true;
      } catch (Exception e) {
          //TODO: handle exception
         return false;
      }

    }

   public boolean eliminarPersonajeMoviePorMovie(Long id){
        try {

          Optional<PeliculasSeriesModel> peliculasSeries= peliculasSeriesRepository.findById(id);
          List<PersonajeModel> personajes= this.personajeMoviesRepository.findByPersonajeMoviesPKPeliculasSeries(peliculasSeries.get());
          int size=personajes.size();
          for(int i=0; i < size; i++){
            Long id_peliculaSerie=peliculasSeries.get().getId();
            Long id_actor= personajes.get(i).getId();
            personajeMoviesRepository.deleteByPersonajeMoviesPK(id_actor,id_peliculaSerie);
          }
          
           
            return true;
        } catch (Exception e) {
            //TODO: handle exception
           return false;
        }
   }



}
