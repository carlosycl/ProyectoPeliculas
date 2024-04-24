package com.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.models.Movie;
import com.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController //controlador que va a estar destinado a resolver las peticiones en formato api rest
@RequestMapping("api/movies") //mepea todas la peticiones que llegan al sitio api movies 

public class MovieControllers {
    
    @Autowired//cablear para evitar la generacion de nuevos objetos 
    private MovieRepository movieRepository;

    //metodo para listar todas las peliculas
    @GetMapping//la uri que se ejecuten con el verbo get retornara todo el listado del repositorio de las peliculas 
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }
    //metodo que devuelve una pelicula por medio de un id
    @GetMapping("/{id}")//para indicar que se esta recibiendo una variable se coloca entre {}
    //ResponseEntity: verifica si el id de la uri si existe 
    //pathVariable permite tomar el id de la uri
    public ResponseEntity<Movie> getMovieById( @PathVariable Long id){
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
}