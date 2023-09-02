package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService iMatriculaService;	
	@GetMapping("/inicio")
    public String inicioMatricula(Materia materia){
        return "vistaInicioMatricula";
    }

	@PostMapping("/guardar")
    public String guardarMatricula(@RequestParam("cd") String cd, @RequestParam("cod1") String cd1,
    		@RequestParam("cod2") String cd2, @RequestParam("cod3") String cd3,@RequestParam("cod4") String cd4 ){
        this.iMatriculaService.ingresar(cd, cd1, cd2, cd3, cd4);
        return "redirect:/matriculas/inicio";
    }
	
	@GetMapping("/buscar") // algo viene y hago algo con eso :V 
    public String buscarTodos(Model model){ // siempre que tebajamos con un modelo
        List<Matricula> lis = this.iMatriculaService.listadoMatriculas();
        model.addAttribute("matriculas", lis);
        return "ListarMatriculas";
	
	}
	

}
