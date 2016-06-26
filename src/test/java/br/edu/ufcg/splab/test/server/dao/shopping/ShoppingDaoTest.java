package br.edu.ufcg.splab.test.server.dao.shopping;

import javax.inject.Inject;

import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.edu.ufcg.splab.dao.client.ClientDao;
import br.edu.ufcg.splab.dao.shopping.ProductDao;
import br.edu.ufcg.splab.dao.shopping.ShoppingDao;
import br.edu.ufcg.splab.pojo.client.Client;
import br.edu.ufcg.splab.pojo.shopping.Product;
import br.edu.ufcg.splab.pojo.shopping.ProductPurchase;
import br.edu.ufcg.splab.pojo.shopping.Purchase;
import br.edu.ufcg.splab.test.ArquillianTestSuite;

@Transactional
public class ShoppingDaoTest extends ArquillianTestSuite {

	@Inject
	private ShoppingDao shoppingDao;
	
	@Inject
	private ProductDao productDao;
	
	@Inject
	private ClientDao clientDao;
	
	private Client client;
	
	private Product computer;
	
	private Product chair;
	
	private Product lampshade;
	
	@BeforeMethod
	public void setUp(){
		client = getDefaultClient();
		computer = getRandomProduct();
		computer.setName("Computer");
		chair = getRandomProduct();
		chair.setName("Chair");
		lampshade = getRandomProduct();
		lampshade.setName("Lampshade");
	}
	
	@Test
	public void testPersist() {
		clientDao.persist(client);
		productDao.persist(computer);
		productDao.persist(chair);
		Purchase purchase = new Purchase(client, computer, chair);
		
		shoppingDao.persist(purchase);
		Assert.assertNotNull(purchase.getId());
		Assert.assertNotNull(purchase.getProducts());
		Assert.assertFalse(purchase.getProducts().isEmpty());
	}

	@Test
	public void testMerge() {
		clientDao.persist(client);
		productDao.persist(computer);
		productDao.persist(chair);
		productDao.persist(lampshade);
		Purchase purchase = new Purchase(client, computer, chair);
		
		shoppingDao.persist(purchase);
		Assert.assertNotNull(purchase.getId());
		Assert.assertNotNull(purchase.getProducts());
		Assert.assertFalse(purchase.getProducts().isEmpty());	
		int currentCartSize = purchase.getProducts().size();

		purchase.addProductPurchase(new ProductPurchase(lampshade));
		
		purchase = shoppingDao.merge(purchase);
		int newCartSize = purchase.getProducts().size();
		Assert.assertEquals(newCartSize, ++currentCartSize);
	}

	@Test
	public void testeFind() {
		clientDao.persist(client);
		productDao.persist(computer);
		productDao.persist(chair);
		Purchase purchase = new Purchase(client, computer, chair);
		
		shoppingDao.persist(purchase);		
		Assert.assertNotNull(purchase.getId());
		Assert.assertNotNull(purchase.getProducts());
		Assert.assertFalse(purchase.getProducts().isEmpty());
		purchase = shoppingDao.find(purchase.getId());
		Assert.assertNotNull(client);
	}

	@Test
	public void testExist() {
		clientDao.persist(client);
		productDao.persist(computer);
		productDao.persist(chair);
		Purchase purchase = new Purchase(client, computer, chair);
		
		shoppingDao.persist(purchase);
		Assert.assertNotNull(purchase.getId());
		Assert.assertNotNull(purchase.getProducts());
		Assert.assertFalse(purchase.getProducts().isEmpty());
		Assert.assertTrue(shoppingDao.exists(purchase.getId()));
	}
}
