package com.test.Libreria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Libreria.model.Libro;

@Service
public class LibroService {
	
	private final LibroRepository libroRepository;
	
	@Autowired
	public LibroService(LibroRepository libroRepository) {
		this.libroRepository = libroRepository;
	}
	
	public List<Libro> getLibros(){
		return libroRepository.findAll();
	}
	
	public Libro getLibro(Long isbn) {
		return libroRepository.findById(isbn).orElseThrow(()->
		new IllegalArgumentException("El libro con el isbn " + isbn + " no existe"));
	}
	
	public Libro deleteLibro(Long isbn) {
		Libro tmpLib = null;
		if(libroRepository.existsById(isbn)) {
			tmpLib = libroRepository.findById(isbn).get();
			libroRepository.deleteById(isbn);
		}
		return tmpLib;
	}
	
	public Libro addLibro(Libro libro) {
		Libro tmpLib = null;
		Optional<Libro> libByTitle = libroRepository.findByTitulo(libro.getTitulo());
		if(libByTitle.isPresent()) {
			throw new IllegalArgumentException("El libro con el titulo [ " + libro.getTitulo() + " ] ya existe");
		}else {
			libroRepository.save(libro);
			tmpLib = libro;
		}
		return tmpLib;
		}
	
	public Libro updateLibro(Long isbn, String titulo, String autor, String editorial, String genero, String fecha_lanzamiento,
			String descripcion, String img) {
		     Libro tmpLib = null;
		      if(libroRepository.existsById(isbn)) {
		    	  tmpLib = libroRepository.findById(isbn).get();
		    	  if(titulo!=null) tmpLib.setTitulo(titulo);
		    	  if(autor!=null) tmpLib.setAutor(autor);
		    	  if(editorial!=null) tmpLib.setEditorial(editorial);
		    	  if(genero!=null) tmpLib.setGenero(genero);
		    	  if(fecha_lanzamiento!=null) tmpLib.setFecha_lanzamiento(fecha_lanzamiento);
		    	  if(descripcion!=null) tmpLib.setDescripcion(descripcion);
		    	  if(img!=null) tmpLib.setImg(img);
		    	  libroRepository.save(tmpLib);
		       }else {
		    	   System.out.println("El libro con el isbn " + isbn + " no existe.");
		       }
		      return tmpLib;
	}
}


