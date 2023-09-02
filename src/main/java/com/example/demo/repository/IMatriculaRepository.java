package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaRepository {
	
	public void ingresar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void borrarPorCedula(String cedula);

	public Matricula seleccionPorCedula(String cedula);
	
	public List<Matricula> listadoMatriculas();

}
