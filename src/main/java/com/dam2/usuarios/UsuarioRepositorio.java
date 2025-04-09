
package com.dam2.usuarios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring into a Bean called usurRepository
//CRUD se refiere a las operaciones Create, Read, Update, Delete

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

	 Usuario findByid(Integer idUsuario);
	 
	 List<Usuario> findByname(String name);
	 


}
