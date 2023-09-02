package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public void ingresar(Materia materia);

	public void actualizar(Materia materia);

	public void borrarPorCodigo(String codigo);

	public Materia seleccionPorCodigo(String codigo);

}
