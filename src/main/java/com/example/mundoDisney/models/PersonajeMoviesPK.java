package com.example.mundoDisney.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PersonajeMoviesPK implements Serializable {
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private PersonajeModel personaje;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private PeliculasSeriesModel peliculasSeries ;

   

    
    public PersonajeModel getPersonaje() {
        return personaje;
    }

    public void setPersonaje(PersonajeModel personaje) {
        this.personaje = personaje;
    }

    public PeliculasSeriesModel getPeliculasSeries() {
        return peliculasSeries;
    }

    public void setPeliculasSeries(PeliculasSeriesModel peliculasSeries) {
        this.peliculasSeries = peliculasSeries;
    }



   
}
