package br.edu.ufcg.splab.rest.shopping;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.ufcg.splab.pojo.shopping.Product;
import br.edu.ufcg.splab.rest.UriResources;
import br.edu.ufcg.splab.services.shopping.ProductService;

@Path(UriResources.PRODUCT)
public class ProductRest {

	@EJB
	private ProductService productService;
	
	@GET
	@Path(UriResources.ROOT)
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		List<Product> products = productService.findAll();
		return Response.ok().entity(products).build();
	}
}
