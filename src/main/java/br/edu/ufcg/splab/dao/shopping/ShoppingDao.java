package br.edu.ufcg.splab.dao.shopping;

import java.util.List;

import javax.persistence.TypedQuery;

import br.edu.ufcg.splab.dao.EntityDao;
import br.edu.ufcg.splab.pojo.shopping.Purchase;

public class ShoppingDao extends EntityDao<Purchase>{

	public List<Purchase> findBy(Long clientId) {
		String criteria = "FROM Purchase p WHERE p.purchaser.id = :clientId";
		TypedQuery<Purchase> query = entityManager.createQuery(criteria , Purchase.class);
		query.setParameter("clientId", clientId);
		return query.getResultList();
	}
}
