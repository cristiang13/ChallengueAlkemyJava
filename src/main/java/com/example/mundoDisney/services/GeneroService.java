package com.example.mundoDisney.services;

import java.util.ArrayList;

import com.example.mundoDisney.models.GeneroModel;
import com.example.mundoDisney.repositories.GeneroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;

    public ArrayList<GeneroModel> obtenerGenero(){
        return (ArrayList<GeneroModel>) generoRepository.findAll();
    }

    public GeneroModel obtenerPorNombre(String nombre){
        return this.generoRepository.findByNombre(nombre);
    }

    public GeneroModel guardarGenero(GeneroModel genero){
        return generoRepository.save(genero);
    }

    public boolean eliminarGenero(Long id){
        try {
            generoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
    }

}
