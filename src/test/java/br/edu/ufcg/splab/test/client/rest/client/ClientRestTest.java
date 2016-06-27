package br.edu.ufcg.splab.test.client.rest.client;

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
import br.edu.ufcg.splab.rest.UriResources;
import br.edu.ufcg.splab.test.ArquillianTestSuite;

public class ClientRestTest extends ArquillianTestSuite {
	
	@ArquillianResource
	private URL base;
	
	private Client client;
	
	@BeforeMethod
	public void setUp(){
		this.client = getRandomClient();
	}

	@Test
	@RunAsClient
	public void testPost(){
		javax.ws.rs.client.Client restClient = ClientBuilder.newBuilder().build();
        WebTarget target = restClient.target(getURI(base, UriResources.CLIENT));
        Entity<Client> entity = Entity.json(client);
		Response response = target.request().post(entity);
        
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK);
        Assert.assertEquals(response.getMediaType().toString(), MediaType.APPLICATION_JSON.toString());
	}
	
	@Test
	@RunAsClient
	public void testGet(){
		javax.ws.rs.client.Client restClient = ClientBuilder.newBuilder().build();
        WebTarget target = restClient.target(getURI(base, UriResources.CLIENT));
        Entity<Client> entity = Entity.json(client);
		Response response = target.request().post(entity);
        
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK);
        Assert.assertEquals(response.getMediaType().toString(), MediaType.APPLICATION_JSON.toString());
        
        client = response.readEntity( Client.class);
        Assert.assertNotNull(client.getId());
        
        target = restClient.target(getURI(base, UriResources.CLIENT, client.getId().toString()));
        response = target.request().get();
        
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK);
        Assert.assertEquals(response.getMediaType().toString(), MediaType.APPLICATION_JSON.toString());
	}
	
	@Test
	@RunAsClient
	public void testPut(){
		javax.ws.rs.client.Client restClient = ClientBuilder.newBuilder().build();
        WebTarget target = restClient.target(getURI(base, UriResources.CLIENT));
        Entity<Client> entity = Entity.json(client);
		Response response = target.request().post(entity);
        
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK);
        Assert.assertEquals(response.getMediaType().toString(), MediaType.APPLICATION_JSON.toString());
        
        client = response.readEntity( Client.class);
        Assert.assertNotNull(client.getId());
        
        client.setName("test Put new Name");
        entity = Entity.json(client);
        
        target = restClient.target(getURI(base, UriResources.CLIENT, client.getId().toString()));
        response = target.request().put(entity);
        
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK);
        Assert.assertEquals(response.getMediaType().toString(), MediaType.APPLICATION_JSON.toString());
	}
}
