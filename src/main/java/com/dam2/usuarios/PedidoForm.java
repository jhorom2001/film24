package com.dam2.usuarios;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PedidoForm {
	@NotNull
	@Size(min=3, max=30, message="El campo nombre debe tener entre 3 y 30 caracteres")
	private String pelicula;
	
	private String anyo;
	private String director;
	private String duracion;
	private String categoria;
	private Usuario usuario;

	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

	
}
