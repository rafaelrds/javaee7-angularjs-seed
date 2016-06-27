package br.edu.ufcg.splab.test.client.rest.shopping;

import java.net.URL;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.edu.ufcg.splab.rest.UriResources;
import br.edu.ufcg.splab.test.ArquillianTestSuite;

public class ProductRestTest extends ArquillianTestSuite {

	@ArquillianResource
	private URL base;

	@Test
	@RunAsClient
	public void testGet() {
		javax.ws.rs.client.Client restClient = ClientBuilder.newBuilder().build();
		WebTarget target = restClient.target(getURI(base, UriResources.PRODUCT));
		Response response = target.request().get();
		
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK);
		Assert.assertEquals(response.getMediaType().toString(), MediaType.APPLICATION_JSON.toString());
	}
}
