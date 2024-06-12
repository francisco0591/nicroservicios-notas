package com.utp.microservicios.app.notas.services;

import java.util.List;
import java.util.Optional;

import com.utp.microservicios.app.notas.entity.Nota;

public interface NotaService {

	public List<Nota> findAll();
	
	public Optional<Nota> findById(Long id);
	
	public Nota save(Nota nota);
	
	public void deleteById(Long id);
	
	public List<Nota> findByUsuario(int usuario);
}
