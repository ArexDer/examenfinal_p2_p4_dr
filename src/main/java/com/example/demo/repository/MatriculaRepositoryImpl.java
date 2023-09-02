package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.merge(matricula);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void borrarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Matricula seleccionPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Matricula> query = this.entityManager.createQuery(
				"SELECT m FROM Matricula e WHERE e.cedula =:datoCedula", Matricula.class);
		query.setParameter("datoCedula", cedula);
		
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Matricula> listadoMatriculas() {
		// TODO Auto-generated method stub
		TypedQuery<Matricula> query = this.entityManager.createQuery(
				"SELECT m FROM Matricula e ", Matricula.class);
		
		return query.getResultList();
	}

}
