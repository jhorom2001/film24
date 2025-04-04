package com.dam2.usuarios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String pelicula;
	private String anyo;
	private String director;
	private String duracion;
	private String categoria;

	

	
	// El pedido pertenece a un único usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	

	public Pedido() {
	}


	public Pedido(String pelicula, Usuario usuario, String anyo) {
		super();
		this.pelicula = pelicula;
		this.usuario = usuario;
	}


	public Pedido(Integer id, String pelicula, String anyo, String director, String duracion, String categoria,
			Usuario usuario) {
		super();
		this.id = id;
		this.pelicula = pelicula;
		this.anyo = anyo;
		this.director = director;
		this.duracion = duracion;
		this.categoria = categoria;
		this.usuario = usuario;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPelicula() {
		return pelicula;
	}


	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
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


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", pelicula=" + pelicula + ", anyo=" + anyo + ", director=" + director
				+ ", duracion=" + duracion + ", categoria=" + categoria + ", usuario=" + usuario + "]";
	}



	







	
}
