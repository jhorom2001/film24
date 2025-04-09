package com.dam2.usuarios;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;



public interface UsuarioServicio extends UserDetailsService{

	public UsuReg guardar(UsuRegDTO registroDTO);
	public List<UsuReg> listarUsuarios();
	
}
