package com.example.mundoDisney.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "PeliculaSerie")
public class PeliculasSeriesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
   private String titulo;
   
   //@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   @JsonFormat(pattern="yyyy-MM-dd")
   private Date fecha_creacion;
   
   @ManyToOne(cascade=CascadeType.PERSIST)
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JoinColumn(referencedColumnName = "id",  nullable = true) 
   private GeneroModel genero ;
   private Integer calificacion;

   


   public long getId() {
       return id;
   }
   public String getTitulo() {
       return titulo;
   }
   public Date getFecha_creacion() {
       return fecha_creacion;
   }
   public Integer getCalificacion() {
       return calificacion;
   }

   public void setId(long id) {
       this.id = id;
   }
   public void setTitulo(String titulo) {
       this.titulo = titulo;
   }
   public void setFecha_creacion(Date fecha_creacion) {
       this.fecha_creacion = fecha_creacion;
   }
   public void setCalificacion(Integer calificacion) {
       this.calificacion = calificacion;
   }
   public GeneroModel getGenero() {
       return genero;
   }
   public void setGenero(GeneroModel genero) {
       this.genero = genero;
   }
}
