package br.edu.ufcg.splab.test.server.dao.client;

import javax.inject.Inject;

import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.edu.ufcg.splab.dao.client.ClientDao;
import br.edu.ufcg.splab.pojo.client.Client;
import br.edu.ufcg.splab.test.ArquillianTestSuite;

@Transactional
public class ClientDaoTest extends ArquillianTestSuite {

	@Inject
	private ClientDao dao;

	@Test
	public void testPersist() {
		Client client = getDefaultClient();
		dao.persist(client);
		Assert.assertNotNull(client.getId());
	}

	@Test
	public void testMerge() {
		Client client = getDefaultClient();
		dao.persist(client);
		Assert.assertNotNull(client.getId());
		client.setName("Peter");
		client = dao.merge(client);
		Assert.assertEquals(client.getName(), "Peter");
	}

	@Test
	public void testeFind() {
		Client client = getDefaultClient();
		dao.persist(client);
		Assert.assertNotNull(client.getId());
		client = dao.find(client.getId());
		Assert.assertNotNull(client);
	}

	@Test
	public void testExist() {
		Client client = getDefaultClient();
		dao.persist(client);
		Assert.assertNotNull(client.getId());
		Assert.assertTrue(dao.exists(client.getId()));
	}
}
