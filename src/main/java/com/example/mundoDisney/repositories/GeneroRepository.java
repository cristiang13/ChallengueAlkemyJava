package com.example.mundoDisney.repositories;

import com.example.mundoDisney.models.GeneroModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends CrudRepository<GeneroModel, Long>{
    public abstract GeneroModel findByNombre(String nombre);
}
