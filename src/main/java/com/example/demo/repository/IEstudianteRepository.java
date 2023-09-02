package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void ingresar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void borrarPorCedula(String cedula);

	public Estudiante seleccionPorCedula(String cedula);

}
