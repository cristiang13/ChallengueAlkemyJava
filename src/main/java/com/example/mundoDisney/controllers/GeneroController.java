package com.example.mundoDisney.controllers;

import java.util.ArrayList;

import com.example.mundoDisney.models.GeneroModel;
import com.example.mundoDisney.services.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    GeneroService generoService;

    @GetMapping
    public ArrayList<GeneroModel> obtenerGenero(){
        return generoService.obtenerGenero();
    }
    
    @PostMapping
    public GeneroModel guardarGenero(@RequestBody GeneroModel genero){
        return this.generoService.guardarGenero(genero);
    }

    

}
