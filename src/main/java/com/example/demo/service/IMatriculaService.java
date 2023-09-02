package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	
	public void ingresar(String cedulaEstu, String cod1, String cod2, String cod3, String cod4);
	
	public List<Matricula> listadoMatriculas();
	
	
	


}
