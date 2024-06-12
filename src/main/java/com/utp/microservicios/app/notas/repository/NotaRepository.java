package com.utp.microservicios.app.notas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.utp.microservicios.app.notas.entity.Nota;

public interface NotaRepository extends CrudRepository<Nota,Long>{
	/**
	 Metodo para listar todo las notas 
	 @author  Francisco Julca
	 */
	List<Nota> findAll();
	/**
	 Metodo para obtener el usuario por id
	 @author  Francisco Julca
	 */
	@Query ("select u from Nota u where u.idUsuario=?1")
	List<Nota> findByUsuario(int usuario);
}
