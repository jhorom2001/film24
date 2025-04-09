package com.dam2.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuRegRepositorio extends JpaRepository<UsuReg, Long> {

	public UsuReg findByEmail(String email);


}
