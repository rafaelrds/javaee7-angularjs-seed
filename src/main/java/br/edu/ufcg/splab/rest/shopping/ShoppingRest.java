package br.edu.ufcg.splab.rest.shopping;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.ufcg.splab.pojo.shopping.Purchase;
import br.edu.ufcg.splab.rest.UriResources;
import br.edu.ufcg.splab.services.shopping.ShoppingService;

@Path(UriResources.CART)
public class ShoppingRest {
	
	@EJB
	private ShoppingService shoppingService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Purchase purchase){
		shoppingService.save(purchase);
		return Response.ok().entity(purchase).build();
	}
	
}
