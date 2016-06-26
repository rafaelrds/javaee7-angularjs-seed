package br.edu.ufcg.splab.services.shopping;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ufcg.splab.dao.shopping.ShoppingDao;
import br.edu.ufcg.splab.pojo.shopping.Purchase;

@Stateless
public class ShoppingBean implements ShoppingService {

	@Inject
	private ShoppingDao dao;

	@Override
	public void save(Purchase purchase) {
		dao.persist(purchase);
	}

	@Override
	public Purchase update(Purchase purchase) {
		return dao.merge(purchase);
	}

	@Override
	public Purchase find(Long purchaseId) {
		return dao.find(purchaseId);
	}

	@Override
	public List<Purchase> findAll(Long clientId) {
		return dao.findBy(clientId);
	}
}
