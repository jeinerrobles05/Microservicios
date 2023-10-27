package com.example.prestamoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestamoservice.model.Prestamo;


public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
   
}

