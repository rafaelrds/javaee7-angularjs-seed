package br.edu.ufcg.splab.dao.shopping;

import java.util.List;

import javax.persistence.TypedQuery;

import br.edu.ufcg.splab.dao.EntityDao;
import br.edu.ufcg.splab.pojo.shopping.Product;

public class ProductDao extends EntityDao<Product>{

	public List<Product> find() {
		String criteria = "FROM Product p";
		TypedQuery<Product> query = entityManager.createQuery(criteria , Product.class);
		return query.getResultList();
	}

}
