package br.edu.ufcg.splab.rest.client;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.ufcg.splab.pojo.shopping.Purchase;
import br.edu.ufcg.splab.rest.UriResources;
import br.edu.ufcg.splab.services.shopping.ShoppingService;

public class HistoryRest {

	private Long clientId;

	@EJB
	private ShoppingService shoppingService;

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@GET
	@Path(UriResources.HISTORY_ID)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam(value = UriResources.HISTORY_ID_PARAM) Long historyId) {
		Purchase purchase = shoppingService.find(historyId);
		return Response.ok().entity(purchase).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		List<Purchase> purchases = shoppingService.findAll(clientId);
		return Response.ok().entity(purchases).build();
	}
}
