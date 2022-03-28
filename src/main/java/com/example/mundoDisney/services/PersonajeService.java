package com.example.mundoDisney.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.mundoDisney.models.PersonajeModel;
import com.example.mundoDisney.repositories.PersonajeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;
    public ArrayList<PersonajeModel> obtenerPersonaje(){
        return (ArrayList<PersonajeModel>) personajeRepository.findAll();
    }

    public PersonajeModel guardarPersonaje(PersonajeModel personaje){
        return personajeRepository.save(personaje);
    }

    public ArrayList<PersonajeModel> obtenerPorNombre(String nombre){
        return personajeRepository.findByNombre(nombre);
    }

    public ArrayList<PersonajeModel> obtenerPorEdad(Integer edad){
        return personajeRepository.findByEdad(edad);
    }

    public Optional<PersonajeModel> obtenerPorId(Long id){
        return this.personajeRepository.findById(id);
    }

    public boolean eliminarPersonaje(Long id){
        try {
            personajeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
    }
}
