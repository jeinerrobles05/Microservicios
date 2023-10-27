package com.example.personaservice.model;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column; 

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @Column(unique = true) // Campo de identificación único
    private Long id;
    private String nombre;
    private String apellido;

    // Getters y setters
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}


