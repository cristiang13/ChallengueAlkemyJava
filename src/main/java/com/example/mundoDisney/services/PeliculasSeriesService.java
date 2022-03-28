package com.example.mundoDisney.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.mundoDisney.models.GeneroModel;
import com.example.mundoDisney.models.PeliculasSeriesModel;
import com.example.mundoDisney.repositories.GeneroRepository;
import com.example.mundoDisney.repositories.PeliculasSeriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculasSeriesService {
   @Autowired
   PeliculasSeriesRepository peliculasSeriesRepository;

   @Autowired
   GeneroRepository generoRepository;
   
   public ArrayList<PeliculasSeriesModel> obtenerPeliculasSeries(){
       return (ArrayList<PeliculasSeriesModel>) peliculasSeriesRepository.findAll();
   }

 
   public PeliculasSeriesModel guardarPeliculasSeries(Map<String, String> peliculasSeries) {
    Object t,f,g,c;
    t="titulo";
    f="fecha_creacion";
    g="genero";
    c="calificacion";

    String titulo,genero,fech;
    titulo=peliculasSeries.get(t);
    SimpleDateFormat fecha= new SimpleDateFormat("yyyy-MM-dd");
    fech=peliculasSeries.get(f);
    Date fechDate=new Date();
    try {
        fechDate = fecha.parse(fech);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    genero=peliculasSeries.get(g);
    GeneroModel gModel= generoRepository.findByNombre(genero);
    Integer cal=Integer.parseInt(peliculasSeries.get(c));
    
    PeliculasSeriesModel p=new PeliculasSeriesModel();

    p.setTitulo(titulo);
    p.setFecha_creacion(fechDate);
    p.setGenero(gModel);
    p.setCalificacion(cal);
    
    return peliculasSeriesRepository.save(p);
   }

   public PeliculasSeriesModel actualizar(PeliculasSeriesModel peliculasSeries){
    
       return peliculasSeriesRepository.save(peliculasSeries);
   }

   public ArrayList<PeliculasSeriesModel>obtenerPorTitulo(String titulo){
       return peliculasSeriesRepository.findByTitulo(titulo);
   }

   public Optional<PeliculasSeriesModel> obtenerPorId(Long id){
    return this.peliculasSeriesRepository.findById(id);
    }

    public ArrayList<PeliculasSeriesModel> obtenerPorGenero(Long id){
        return this.peliculasSeriesRepository.findByGeneroId(id);
        }
   
   public boolean eliminarPeliculasSeries(Long id){
       try {
           peliculasSeriesRepository.deleteById(id);
           return true;
       } catch (Exception e) {
           //TODO: handle exception
           return false;
       }
   }
}
