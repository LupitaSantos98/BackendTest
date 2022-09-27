package com.test.Libreria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Libreria.model.Usuario;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElseThrow(()->
		new IllegalArgumentException("El usuario con el id " + id + " no existe"));
	}
	
	public Usuario deleteUsuario(Long id) {
		Usuario tmpUsuar = null;
		if(usuarioRepository.existsById(id)) {
			tmpUsuar = usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}
		return tmpUsuar;
	}
	
	public Usuario addUsuario(Usuario usuario) {
		Usuario tmpUsuar = null;
		Optional<Usuario> usuarByName = usuarioRepository.findByNombre(usuario.getNombre());
		if(usuarByName.isPresent()) {
			throw new IllegalArgumentException("El usuario con el titulo [ " + usuario.getNombre() + " ] ya existe");
		}else {
			usuarioRepository.save(usuario);
			tmpUsuar = usuario;
		}
		return tmpUsuar;
		}
	
	public Usuario updateUsuario(Long id, String nombre, String apellido_paterno, String apellido_materno, String direccion,
			String telefono, String username, String contrasena) {
		     Usuario tmpUsuar = null;
		      if(usuarioRepository.existsById(id)) {
		    	  tmpUsuar = usuarioRepository.findById(id).get();
		    	  if(nombre!=null) tmpUsuar.setNombre(nombre);
		    	  if(apellido_paterno!=null) tmpUsuar.setApellido_paterno(apellido_paterno);
		    	  if(apellido_materno!=null) tmpUsuar.setApellido_materno(apellido_materno);
		    	  if(direccion!=null) tmpUsuar.setDireccion(direccion);
		    	  if(telefono!=null) tmpUsuar.setTelefono(telefono);
		    	  if(username!=null) tmpUsuar.setUsername(username);
		    	  if(contrasena!=null) tmpUsuar.setContrasena(contrasena);
		    	  usuarioRepository.save(tmpUsuar);
		       }else {
		    	   System.out.println("El usuario con el id " + id + " no existe.");
		       }
		      return tmpUsuar;
	}

}
