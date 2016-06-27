package br.edu.ufcg.splab.services.shopping;

import java.util.List;

import javax.ejb.Local;

import br.edu.ufcg.splab.pojo.shopping.Purchase;

@Local
public interface ShoppingService {
	
	void save(Purchase purchase);

	Purchase update(Purchase purchase);

	Purchase find(Long purchaseId);
	
	List<Purchase> findAll(Long clientId);
}
