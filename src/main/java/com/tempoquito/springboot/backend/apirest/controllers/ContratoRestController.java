package com.tempoquito.springboot.backend.apirest.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tempoquito.springboot.backend.apirest.models.entity.Contrato;
import com.tempoquito.springboot.backend.apirest.models.services.IContratoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ContratoRestController {

	@Autowired
	private IContratoService contratoService;

	@GetMapping("/contratos")
	public List<Contrato> index() {
		return contratoService.findAll();
	}

	@GetMapping("/contratos/{id}")
	public Contrato show(@PathVariable Long id) {
		return contratoService.findById(id);
	}

	@PostMapping("/contratos")
	@ResponseStatus(HttpStatus.CREATED)
	public Contrato create(@RequestBody Contrato contrato) {
		return contratoService.save(contrato);
	}

	@PutMapping("/contratos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Contrato update(@RequestBody Contrato contrato, @PathVariable Long id) {
		Contrato contratoActual = contratoService.findById(id);
		// Aquí puedes agregar la lógica para actualizar los campos del contrato
		return contratoService.save(contratoActual);
	}

	@DeleteMapping("/contratos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		contratoService.delete(id);
	}
}
