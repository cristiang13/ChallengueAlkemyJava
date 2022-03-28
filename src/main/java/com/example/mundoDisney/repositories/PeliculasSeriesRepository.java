package com.example.mundoDisney.repositories;

import java.util.ArrayList;

import com.example.mundoDisney.models.PeliculasSeriesModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasSeriesRepository extends CrudRepository<PeliculasSeriesModel, Long>{
    public abstract ArrayList<PeliculasSeriesModel> findByTitulo(String titulo);
   public abstract ArrayList<PeliculasSeriesModel> findByGeneroId(Long idGenero);

    
}
