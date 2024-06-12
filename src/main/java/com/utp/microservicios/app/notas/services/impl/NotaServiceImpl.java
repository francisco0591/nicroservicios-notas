package com.utp.microservicios.app.notas.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.microservicios.app.notas.entity.Nota;
import com.utp.microservicios.app.notas.repository.NotaRepository;
import com.utp.microservicios.app.notas.services.NotaService;

@Service
public class NotaServiceImpl implements NotaService{

	@Autowired
	private NotaRepository notaRepository;
	
	
	/**
	 Metodo para obtener el listado de notas
	 @author  Francisco Julca
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Nota> findAll() {
		// TODO Auto-generated method stub
		return notaRepository.findAll();
	}

	/**
	 Metodo para obtener el registro de la nota por id
	 @author  Francisco Julca
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<Nota> findById(Long id) {
		// TODO Auto-generated method stub
		return notaRepository.findById(id);
	}

	/**
	 Metodo para registrar la nota
	 @author  Francisco Julca
	 */
	@Override
	@Transactional()
	public Nota save(Nota nota) {
		return notaRepository.save(nota);
	}

	/**
	 Metodo para obtener eliminar el usuario por id
	 @author  Francisco Julca
	 */
	@Override
	@Transactional()
	public void deleteById(Long id) {
		 notaRepository.deleteById(id);
	}
	
	/**
	 Metodo para obtener el usuario por id
	 @author  Francisco Julca
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Nota> findByUsuario(int usuario) {
		// TODO Auto-generated method stub
		return notaRepository.findByUsuario(usuario);
	}


}
