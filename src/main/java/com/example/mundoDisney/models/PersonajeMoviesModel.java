package com.example.mundoDisney.models;

import javax.persistence.*;

@Entity
@Table(name = "PersonajeMovies")
public class PersonajeMoviesModel {

    @EmbeddedId
    private PersonajeMoviesPK personajeMoviesPK;

  

    public PersonajeMoviesPK getPersonajeMoviesPK() {
        return personajeMoviesPK;
    }

    public void setPersonajeMoviesPK(PersonajeMoviesPK personajeMoviesPK) {
        this.personajeMoviesPK = personajeMoviesPK;
    }

}
