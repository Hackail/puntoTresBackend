package com.pruebaTecnica.backendPruebaTecnica.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaTecnica.backendPruebaTecnica.DTOs.PersonaDTO;
import com.pruebaTecnica.backendPruebaTecnica.entidades.Persona;
import com.pruebaTecnica.backendPruebaTecnica.negocio.NegocioPersona;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/webresources/servicios/persona")
public class ServicioPersona {
	
	@Autowired
	private NegocioPersona negocioPersona;
	
	@GetMapping("/listar")
	public List<Persona> traerTodas() {
		return negocioPersona.traerTodas();
	}
	
	@GetMapping("/buscarPorId")
	public Persona traerTodas(@RequestParam(value="numDocument") String numDocument) {
		return negocioPersona.buscarPorId(numDocument);
	}
	
	@PostMapping("/crear")
	public Persona crearPersona(@RequestBody PersonaDTO persona) {
		return negocioPersona.crearPersona(persona);
	}

}
