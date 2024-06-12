package com.utp.microservicios.app.notas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.utp.microservicios.app.notas.entity.Usuario; 


@Repository
public interface  UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	/**
	 Metodo para obtener el usuario por nombre
	 @author  Francisco Julca
	 */
	@Query ("select u from Usuario u where u.usuario=?1")
	Usuario findByUsuario(String usuario);
	
	
}
