package com.example.mundoDisney.models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "Genero")
public class GeneroModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String nombre;



    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
