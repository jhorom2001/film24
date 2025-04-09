
package com.dam2.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioForm {
	@NotNull
	@Size(min=3, max=30, message="El campo nombre debe tener entre 3 y 30 caracteres")
	private String name;
	@Size(min=3, max=30, message="El campo nombre debe tener entre 3 y 30 caracteres")
	private String apellido;

	
	@Email (message = "Email debe ser valido")
	private String email;
	

	private String dni;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	


		
}
