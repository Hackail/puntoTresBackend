package com.pruebaTecnica.backendPruebaTecnica.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaTecnica.backendPruebaTecnica.DTOs.PersonaDTO;
import com.pruebaTecnica.backendPruebaTecnica.entidades.Persona;
import com.pruebaTecnica.backendPruebaTecnica.manejador.ManejadorPersona;

@Service
public class NegocioPersona {

	@Autowired
	private ManejadorPersona manejadorPersona;

	public List<Persona> traerTodas() {
		return manejadorPersona.findAll();
	}

	public Persona buscarPorId(String numDocument) {
		if (manejadorPersona.findById(numDocument).isPresent()) {
			return manejadorPersona.findById(numDocument).get();
		} else {
			return null;
		}
	}

	public Persona crearPersona(PersonaDTO persona) {
		Persona per = buscarPorId(persona.getNumDocument());
		if (per == null) {
			Persona nueva = new Persona();
			nueva.setFirstName(persona.getFirstName());
			nueva.setLastName(persona.getLastName());
			nueva.setFullName(persona.getFirstName() + " " + persona.getLastName());
			nueva.setBirth(persona.getBirth());
			nueva.setNumDocument(persona.getNumDocument());
			if (persona.getParent() != null && persona.getParent() != "") {
				Persona parent = buscarPorId(persona.getParent());
				if (parent != null) {
					nueva.setParent(parent);
				}
			}
			return manejadorPersona.save(nueva);
		} else {
			return null;
		}
	}
}
