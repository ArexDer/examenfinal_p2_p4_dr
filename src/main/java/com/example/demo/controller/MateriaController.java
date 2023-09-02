package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@GetMapping("/inicio")
    public String inicioMateria(Materia materia){
        return "vistaInicioMateria";
    }

	@PostMapping("/guardar")
    public String guardarMateria(Materia materia){
        this.iMateriaService.guardar(materia);
        return "redirect:/materias/inicio";
    }

}
