package com.dam2.usuarios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PedidoRepositorio extends CrudRepository<Pedido, Integer> {

	List<Pedido> findByPelicula(String pelicula);

	List<Pedido> findByusuario(Usuario usuario);

}
