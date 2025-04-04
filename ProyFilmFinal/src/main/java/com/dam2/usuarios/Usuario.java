package com.dam2.usuarios;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	//Un usuario tiene varios pedidos
	@OneToMany(mappedBy="usuario") 
	private List<Pedido> listaPedidos;
	
	public Usuario() {
		super();
	}

	public Usuario(String name, String email,String apellido,String dni) {
		super();
		this.name = name;
		this.email = email;
		this.apellido=apellido;
		this.dni=dni;
	}
	
	private String email;
	private String apellido;
	private String dni;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	

	
}
