package br.edu.ufcg.splab.dao;

import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.google.common.reflect.TypeToken;

public abstract class EntityDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	@SuppressWarnings("serial")
	protected final TypeToken<T> typeToken = new TypeToken<T>(getClass()) {
	};

	@SuppressWarnings("unchecked")
	protected Class<T> getClassOfEntity() {
		return (Class<T>) typeToken.getRawType();
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public T merge(T entity) {
		return entityManager.merge(entity);
	}

	public T find(Object pk) {
		return entityManager.find(getClassOfEntity(), pk);
	}

	public boolean exists(Object pk) {
		try {
			Object entity = entityManager.find(getClassOfEntity(), pk);
			return entity != null;
		} catch (NoResultException ex) {
			return false;
		}
	}

}
