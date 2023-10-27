package com.example.personaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.personaservice.model.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Long> {
   
}

