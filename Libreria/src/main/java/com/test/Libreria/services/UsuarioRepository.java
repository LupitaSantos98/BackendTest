package com.test.Libreria.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.Libreria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("SELECT u FROM Usuario u WHERE u.nombre=?1")
	Optional<Usuario> findByNombre(String nombre);

}
