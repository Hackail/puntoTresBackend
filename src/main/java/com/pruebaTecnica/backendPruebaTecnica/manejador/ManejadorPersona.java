package com.pruebaTecnica.backendPruebaTecnica.manejador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.pruebaTecnica.backendPruebaTecnica.entidades.Persona;

@Service
public interface ManejadorPersona extends JpaRepository<Persona, String> {

}
