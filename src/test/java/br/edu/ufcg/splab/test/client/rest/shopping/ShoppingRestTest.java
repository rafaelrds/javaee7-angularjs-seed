package br.edu.ufcg.splab.test.client.rest.shopping;

import java.net.URL;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.edu.ufcg.splab.pojo.client.Client;
import br.edu.ufcg.splab.pojo.shopping.Product;
import br.edu.ufcg.splab.pojo.shopping.Purchase;
import br.edu.ufcg.splab.rest.UriResources;
import br.edu.ufcg.splab.test.ArquillianTestSuite;
import br.edu.ufcg.splab.test.DBIds;

public class ShoppingRestTest extends ArquillianTestSuite {

	@ArquillianResource
	private URL base;

	private Client client;

	private Product computer;

	private Product chair;

	private Product lampshade;

	@BeforeMethod
	public void setUp() {
		client = getDefaultClient();
		computer = getRandomProduct();
		computer.setName("Computer");
		computer.setId(DBIds.PRODUCT_PC_ASUS.getId());
		chair = getRandomProduct();
		chair.setName("Chair");
		chair.setId(DBIds.PRODUCT_CHAIR_BOSS.getId());
		lampshade = getRandomProduct();
		lampshade.setName("Lampshade");
		lampshade.setId(DBIds.PRODUCT_LAMP_FANCY.getId());
	}

	@Test
	@RunAsClient
	public void testPost() {
		getClient();
		Purchase purchase = new Purchase(client, chair, computer, lampshade);

		javax.ws.rs.client.Client restClient = ClientBuilder.newBuilder().build();
		WebTarget target = restClient.target(getURI(base, UriResources.CART));
		Entity<Purchase> entity = Entity.json(purchase);
		Response response = target.request().post(entity);

		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK);
		Assert.assertEquals(response.getMediaType().toString(), MediaType.APPLICATION_JSON.toString());
	}

	private void getClient() {
		javax.ws.rs.client.Client restClient = ClientBuilder.newBuilder().build();
		WebTarget target = restClient.target(getURI(base, UriResources.CLIENT));
		Entity<Client> entity = Entity.json(client);
		Response response = target.request().post(entity);
		client = response.readEntity(Client.class);
	}
}
