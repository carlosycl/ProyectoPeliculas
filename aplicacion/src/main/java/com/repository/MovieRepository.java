package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.models.Movie;

//creacion, busqueda, eliminado, actualizacion  
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
