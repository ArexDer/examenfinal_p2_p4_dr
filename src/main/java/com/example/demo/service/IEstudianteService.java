package com.example.demo.service;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminarPorCedula(String cedula);

	public Estudiante buscarPorCedula(String cedula);

}
