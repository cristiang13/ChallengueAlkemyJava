package com.example.mundoDisney.repositories;

import java.util.ArrayList;

import com.example.mundoDisney.models.PersonajeModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends CrudRepository<PersonajeModel, Long>{
    public abstract ArrayList<PersonajeModel> findByNombre(String nombre);
   
    public abstract ArrayList<PersonajeModel> findByEdad(Integer edad);

}
