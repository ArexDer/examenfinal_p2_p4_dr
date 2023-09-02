package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService service;
	
	@GetMapping("/inicio")
    public String inicioEstudiante(Estudiante estudiante){
        return "VistaInicioEstudiante";
    }

	@PostMapping("/guardar")
    public String guardarEstudiante(Estudiante estudiante){
        this.service.guardar(estudiante);
        return "redirect:/estudiantes/inicio";
    }

}



	
	