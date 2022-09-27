package com.test.Libreria.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.Libreria.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	@Query("SELECT l FROM Libro l WHERE l.titulo=?1")
	Optional<Libro> findByTitulo(String titulo);
}
