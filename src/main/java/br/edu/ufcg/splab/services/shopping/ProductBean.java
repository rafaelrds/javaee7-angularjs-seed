package br.edu.ufcg.splab.services.shopping;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ufcg.splab.dao.shopping.ProductDao;
import br.edu.ufcg.splab.pojo.shopping.Product;

@Stateless
public class ProductBean implements ProductService {

	@Inject
	private ProductDao dao;

	@Override
	public void save(Product product) {
		dao.persist(product);
	}

	@Override
	public Product update(Product product) {
		return dao.merge(product);
	}

	@Override
	public Product find(Product productId) {
		return dao.find(productId);
	}

	@Override
	public List<Product> findAll() {
		return dao.find();
	}
}
