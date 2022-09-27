package com.test.Libreria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="isbn", unique= true, nullable = false)
	private Long isbn;
	private String titulo;
	private String autor; 
	private String editorial;
	private String genero;
	private String fecha_lanzamiento;
	private String descripcion;
	private String img;
	
	public Libro(Long isbn, String titulo, String autor, String editorial, String genero, String fecha_lanzamiento,
			String descripcion, String img) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.genero = genero;
		this.fecha_lanzamiento = fecha_lanzamiento;
		this.descripcion = descripcion;
		this.img = img;
	}

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}

	public void setFecha_lanzamiento(String fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", genero=" + genero + ", fecha_lanzamiento=" + fecha_lanzamiento + ", descripcion=" + descripcion
				+ ", img=" + img + "]";
	}
	
	
	

}
