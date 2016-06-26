package br.edu.ufcg.splab.test.server.dao.shopping;

import javax.inject.Inject;

import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.edu.ufcg.splab.dao.shopping.ProductDao;
import br.edu.ufcg.splab.pojo.shopping.Product;
import br.edu.ufcg.splab.test.ArquillianTestSuite;

@Transactional
public class ProductDaoTest extends ArquillianTestSuite {

	@Inject
	private ProductDao dao;

	@Test
	public void testPersist() {
		Product product = getDefaultProduct();
		dao.persist(product);
		Assert.assertNotNull(product.getId());
	}

	@Test
	public void testMerge() {
		Product product = getDefaultProduct();
		dao.persist(product);
		Assert.assertNotNull(product.getId());

		product.setName("Computador Positivo All in One");
		product = dao.merge(product);
		Assert.assertEquals(product.getName(), "Computador Positivo All in One");
	}

	@Test
	public void testeFind() {
		Product product = getDefaultProduct();
		dao.persist(product);
		Assert.assertNotNull(product.getId());
		product = dao.find(product.getId());
		Assert.assertNotNull(product);
	}

	@Test
	public void testExist() {
		Product product = getDefaultProduct();
		dao.persist(product);
		Assert.assertNotNull(product.getId());
		Assert.assertTrue(dao.exists(product.getId()));
	}
}
