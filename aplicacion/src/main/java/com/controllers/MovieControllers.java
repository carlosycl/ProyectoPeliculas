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

/*
 * @RestController: controlador que va a estar destinado a resolver las peticiones en formato api rest
 * @RequestMapping: mepea todas la peticiones que llegan al sitio api movies 
 */

@RestController 
@RequestMapping("api/movies")  

public class MovieControllers {
    
    /*@Autowired: cablear para evitar la generacion de nuevos objetos
     *metodo para listar todas las peliculas
     *@GetMapping: la uri que se ejecuten con el verbo get retornara todo el listado del repositorio de las peliculas
     */

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping//  
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    /*metodo que devuelve una pelicula por medio de un id
     * @GetMapping("/{id}"): para indicar que se esta recibiendo una variable se coloca entre {}
     * ResponseEntity: verifica si el id de la uri si existe 
     * pathVariable: indica que el parámetro id se extrae de la ruta de la URL. Por ejemplo, /movies/5, el valor 5 se asignará al parámetro id.
     * Optional<Movie> para encapsular el resultado de una operación que podría no tener un valor.
     * movieRepository.findById: busca una película por su ID usando movieRepository, que es un objeto que interactúa con la base de datos. 
       El resultado se almacena en la variable movie, que es de tipo Optional<Movie>.
     * orElseGet: Si no se encuentra la película (es decir, el Optional está vacío), se usa orElseGet para especificar una respuesta alternativa. 
       Aquí, se usa para devolver ResponseEntity.notFound().build(), lo que indica un estado HTTP 404 (no encontrado).
     */
    
    @GetMapping("/{id}") 
    //
    public ResponseEntity<Movie> getMovieById( @PathVariable Long id){
        
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
        // 
    }
}