package com.utp.microservicios.app.notas.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
Clase Entity Nota
@author  Francisco Julca
*/
@Entity
@Table(name="NOTA")
public class Nota implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Min(0) @Max(20)
	private int nota1;
	@Min(0) @Max(20)
	private int nota2;
	@Min(0) @Max(20)
	private int nota3;
	@Min(0) @Max(20)
	private int nota4;
	private int promedio;
	@Min(1)
	@Column(name="IDUSUARIO")
	@Min(1)
	private int idUsuario;
	@NotNull
	@Column(name="IDCURSO")
	private int idCurso;
	
	
	public Nota() {
		super();
	}

	public Nota(Long id, int nota1, int nota2, int nota3, int nota4, int promedio, int idUsuario, int idCurso) {
		super();
		this.id = id;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.promedio = promedio;
		this.idUsuario = idUsuario;
		this.idCurso = idCurso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public int getNota3() {
		return nota3;
	}

	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}

	public int getNota4() {
		return nota4;
	}

	public void setNota4(int nota4) {
		this.nota4 = nota4;
	}

	

	public int getPromedio() {
		return promedio;
	}

	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}

	

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	
	
}
