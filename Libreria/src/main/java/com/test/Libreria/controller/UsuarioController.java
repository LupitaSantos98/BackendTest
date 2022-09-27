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

import com.test.Libreria.model.Usuario;
import com.test.Libreria.services.*;

@RestController
@RequestMapping(path="/test/users/")
public class UsuarioController {
	
private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	

	@GetMapping
	public List<Usuario> getAllUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	@GetMapping(path="{usuarId}")
	public Usuario getUsuario(@PathVariable("usuarId")Long id) {
		return usuarioService.getUsuario(id);
	}
	

	@DeleteMapping(path="{usuarId}")
	public Usuario deleteUsuario(@PathVariable("usuarId") Long id) {
		return usuarioService.deleteUsuario(id);
	}
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario){
		return usuarioService.addUsuario(usuario);
	}
	
	@PutMapping(path="{usuarId}")
	public Usuario updateUsuario(@PathVariable("usuarId")Long id, 
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String apellido_paterno,
			@RequestParam(required = false) String apellido_materno,
			@RequestParam(required = false) String direccion,
			@RequestParam(required = false) String telefono,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String contrasena) {
		return usuarioService.updateUsuario(id, nombre, apellido_paterno, apellido_materno, direccion, telefono, username, contrasena);
	}
	

}
