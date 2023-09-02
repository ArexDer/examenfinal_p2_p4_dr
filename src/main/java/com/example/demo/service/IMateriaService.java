package com.example.demo.service;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {
	
	public void guardar(Materia materia);

	public void actualizar(Materia materia);

	public void eliminarPorCodigo(String codigo);

	public Materia buscarPorCodigo(String codigo);

}
