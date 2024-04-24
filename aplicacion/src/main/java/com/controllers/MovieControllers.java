package com.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.models.Movie;
import com.repository.MovieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController //controlador que va a estar destinado a resolver las peticiones en formato api rest
@RequestMapping("api/movies") //mepea todas la peticiones que llegan al sitio api movies 

public class MovieControllers {
    
    @Autowired//cablear para evitar la generacion de nuevos objetos 
    private MovieRepository movieRepository;

    //metodo para listar todas las peliculas
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }
}