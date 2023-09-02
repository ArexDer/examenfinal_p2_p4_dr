package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void borrarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query = this.entityManager.createQuery(
				"SELECT m FROM Materia m WHERE m.codigo =:datoCodigo", Materia.class);
		query.setParameter("datoCedula", codigo);
		
		return query.getSingleResult();
	}

}
