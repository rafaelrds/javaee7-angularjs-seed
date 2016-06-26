package br.edu.ufcg.splab.services.shopping;

import java.util.List;

import javax.ejb.Local;

import br.edu.ufcg.splab.pojo.shopping.Product;

@Local
public interface ProductService {

	void save(Product product);

	Product update(Product product);

	Product find(Product productId);
	
	List<Product> findAll();
}
