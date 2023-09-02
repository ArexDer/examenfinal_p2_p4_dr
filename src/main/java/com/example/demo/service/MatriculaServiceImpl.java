package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Autowired
	private IMateriaRepository iMateriaRepository;
	
    @Autowired
    private IMatriculaRepository iMatriculaRepository;

	@Override
	public void ingresar(String cedulaEstu, String cod1, String cod2, String cod3, String cod4) {
		// TODO Auto-generated method stub
		Estudiante estuAux = this.estudianteRepository.seleccionPorCedula(cedulaEstu);
		Materia ma1 =this.iMateriaRepository.seleccionPorCodigo(cod1);
		Materia ma2 =this.iMateriaRepository.seleccionPorCodigo(cod2);
		Materia ma3 =this.iMateriaRepository.seleccionPorCodigo(cod3);
		Materia ma4 =this.iMateriaRepository.seleccionPorCodigo(cod4);
		
		List<String> listM =new ArrayList();
		listM.add(cod1);
		listM.add(cod2);
		
		List<Materia> li = new ArrayList();
		li.add(ma1);
		li.add(ma2);
		li.add(ma3);
		li.add(ma4);
		
		List<Matricula> lista = IntStream.range(0, 4)
			    .mapToObj(i -> {
			    	Matricula matricula = Matricula.builder().estudiante(estuAux).materia(li).build();
			    	
			    	return matricula;
			    
			    })
			    .collect(Collectors.toList());
		
		lista.forEach(datos -> this.iMatriculaRepository.ingresar(datos));
		
		this.estudianteRepository.actualizar(estuAux);
		
	}

	@Override
	public List<Matricula> listadoMatriculas() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
