package com.utp.microservicios.app.notas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.utp.microservicios.app.notas.entity.Nota;
import com.utp.microservicios.app.notas.services.NotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.*;

/**
Clase Controller Nota para los servicios nota
@author  Francisco Julca
*/
@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping(value = "nota")
public class NotaController {

	@Autowired
	private NotaService notaService;

	@Operation(summary = "Listar Nota", description = "Servicio que lista toda las notas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@GetMapping("/")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(notaService.findAll());
	}

	@Operation(summary = "Buscar nota por id", description = "Servicio que busca las notas por su id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarxId(@PathVariable Long id) {
		Optional<Nota> nota = notaService.findById(id);
		if (nota.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(nota.get());
	}

	@Operation(summary = "Registra nota", description = "Servicio que registra las notas de los alumnos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody Nota nota, BindingResult result) {

		if (result.hasErrors()) {
			return this.validar(result);
		}
		int promedio = Math.round((nota.getNota1() + nota.getNota2() + nota.getNota3() + nota.getNota4()) / 4);
		nota.setPromedio(promedio);
		Nota notaDb = notaService.save(nota);
		return ResponseEntity.status(HttpStatus.CREATED).body(notaDb);

	}

	@Operation(summary = "Ver notas por usuario", description = "Servicio que lista las notas por usuario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@GetMapping("/verNotasxUsuario/{idUsuario}")
	public ResponseEntity<?> verNotasxUsuario(@PathVariable int idUsuario) {
		List<Nota> usuario = notaService.findByUsuario(idUsuario);
		if (usuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(usuario);

	}

	@Operation(summary = "Actualizar nota", description = "Servicio que actualiza las notas de los alumnos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Nota nota, @PathVariable Long id) {
		Optional<Nota> notaOp = notaService.findById(id);
		if (notaOp.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Nota notaDb = notaOp.get();
		notaDb.setNota1(nota.getNota1());
		notaDb.setNota2(nota.getNota2());
		notaDb.setNota3(nota.getNota3());
		int promedio = Math.round((notaDb.getNota1() + notaDb.getNota2() + notaDb.getNota3() + notaDb.getNota4()) / 4);
		notaDb.setPromedio(promedio);
		return ResponseEntity.status(HttpStatus.CREATED).body(notaService.save(notaDb));
	}

	@Operation(summary = "Eliminar nota", description = "Servicio que elimina la nota por su id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		notaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(
				err -> errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errores);
	}
}
