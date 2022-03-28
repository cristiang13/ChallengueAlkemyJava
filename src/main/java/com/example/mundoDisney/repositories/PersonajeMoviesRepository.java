package com.example.mundoDisney.repositories;


import java.util.*;

import javax.transaction.Transactional;

import com.example.mundoDisney.models.PeliculasSeriesModel;
import com.example.mundoDisney.models.PersonajeModel;
import com.example.mundoDisney.models.PersonajeMoviesModel;
import com.example.mundoDisney.models.PersonajeMoviesPK;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeMoviesRepository extends CrudRepository<PersonajeMoviesModel, PersonajeMoviesPK>{
    
    @Query("SELECT p.personajeMoviesPK.peliculasSeries FROM PersonajeMoviesModel p where p.personajeMoviesPK.personaje = ?1")
    public abstract List<PeliculasSeriesModel> findByPersonajeMoviesPKPersonaje(PersonajeModel personaje);

    //public abstract ArrayList<PersonajeMoviesModel> findByPersonajeMoviesPKPeliculasSeries(PeliculasSeriesModel peliculaSerie);
    
    @Query("SELECT p.personajeMoviesPK.personaje FROM PersonajeMoviesModel p where p.personajeMoviesPK.peliculasSeries = ?1")
   public abstract List<PersonajeModel> findByPersonajeMoviesPKPeliculasSeries(PeliculasSeriesModel peliculaSerie);

   @Transactional
   @Modifying
   @Query("DELETE FROM PersonajeMoviesModel p WHERE p.personajeMoviesPK.personaje.id = ?1 and p.personajeMoviesPK.peliculasSeries.id = ?2")
   //public void deleteByPersonajeMoviesPKPersonaje(Long id1,Long id2);
   public void deleteByPersonajeMoviesPK(Long id1,Long id2);
}
