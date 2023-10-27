package com.example.prestamoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.prestamoservice.model.Prestamo;
import com.example.prestamoservice.repository.PrestamoRepository;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoRepository prestamoRepository;

    @Autowired
    public PrestamoController(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @GetMapping("/create")
    public String mostrarFormulario(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        return "/formularioPrestamo";
    }

    @PostMapping("/save")
    public String guardarPrestamo(@ModelAttribute Prestamo prestamo, Model model) {
        prestamoRepository.save(prestamo);
        model.addAttribute("exito", "Prestamo guardado con éxito.");
        return "redirect:/prestamos/";
    }

    @GetMapping("/")
    public String listarPrestamos(Model model) {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        model.addAttribute("prestamos", prestamos);
        return "/listarPrestamos";
    }
}

