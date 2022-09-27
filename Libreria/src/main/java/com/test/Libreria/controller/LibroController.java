package com.test.Libreria.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.Libreria.model.Libro;
import com.test.Libreria.services.*;

@RestController
@RequestMapping(path="/test/books/")
public class LibroController {
	
	private final LibroService libroService;
	
	@Autowired
	public LibroController(LibroService libroService) {
		this.libroService = libroService;
	}
	
	@GetMapping
	public List<Libro> getAllLibros(){
		return libroService.getLibros();
	}
	
	@GetMapping(path="{libISBN}")
	public Libro getLibro(@PathVariable("libISBN")Long isbn) {
		return libroService.getLibro(isbn);
	}
	
	@DeleteMapping(path="{libISBN}")
	public Libro deleteLibro(@PathVariable("libISBN") Long isbn) {
		return libroService.deleteLibro(isbn);
	}
	
	@PostMapping
	public Libro addLibro(@RequestBody Libro libro){
		return libroService.addLibro(libro);
	}
	
	@PutMapping(path="{libISBN}")
	public Libro updateLibro(@PathVariable("libISBN")Long isbn, 
			@RequestParam(required = false) String titulo,
			@RequestParam(required = false) String autor,
			@RequestParam(required = false) String editorial,
			@RequestParam(required = false) String genero,
			@RequestParam(required = false) String fecha_lanzamiento,
			@RequestParam(required = false) String descripcion,
			@RequestParam(required = false) String img) {
		return libroService.updateLibro(isbn, titulo, autor, editorial, genero, fecha_lanzamiento, descripcion, img);
	}
	

}
