package com.example.personaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.personaservice.model.Persona;
import com.example.personaservice.repository.PersonaRepository;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @GetMapping("/create")
    public String mostrarFormulario(Model model) {
        model.addAttribute("persona", new Persona());
        return "/formularioPersona";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona, Model model) {
        // Verificar si el ID ya está en uso
        if (personaRepository.existsById(persona.getId())) {
            model.addAttribute("error", "El ID ya está en uso.");
            return "/formularioPersona";
        }

        // Si el ID no está en uso, guardar la persona
        personaRepository.save(persona);
        model.addAttribute("exito", "Persona guardada con éxito.");

        return "redirect:/personas/";
    }

    @GetMapping("/")
    public String listarPersonas(Model model) {
        List<Persona> personas = personaRepository.findAll();
        model.addAttribute("personas", personas);
        return "/listarPersonas";
    }
}

