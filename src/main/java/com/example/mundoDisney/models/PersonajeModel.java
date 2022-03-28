package com.example.mundoDisney.models;

import javax.persistence.*;


@Entity
@Table(name = "Personaje")
public class PersonajeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String nombre;
    private Integer edad;
    private double peso;

    @Column(columnDefinition = "TEXT")
    private String historia;

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public Integer getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }
    public String getHistoria() {
        return historia;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public void setHistoria(String historia) {
        this.historia = historia;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
}
