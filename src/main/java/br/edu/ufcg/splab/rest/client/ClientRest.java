package br.edu.ufcg.splab.rest.client;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.ufcg.splab.pojo.client.Client;
import br.edu.ufcg.splab.rest.UriResources;
import br.edu.ufcg.splab.services.client.ClientService;

@Path(UriResources.CLIENT)
public class ClientRest {

	@Inject
	private HistoryRest history;

	@EJB
	private ClientService clientService;

	@Path(UriResources.HISTORY)
	public HistoryRest getShoppingHistory(@PathParam(value = UriResources.CLIENT_ID_PARAM) Long clientId) {
		history.setClientId(clientId);
		return history;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Client client) {
		clientService.save(client);
		return Response.ok().entity(client).build();
	}

	@PUT
	@Path(UriResources.CLIENT_ID)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(Client client) {
		Client updatedClient = clientService.update(client);
		return Response.ok().entity(updatedClient).build();
	}

	@GET
	@Path(UriResources.CLIENT_ID)
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam(value = UriResources.CLIENT_ID_PARAM) Long clientId) {
		Client client = clientService.find(clientId);
		return Response.ok().entity(client).build();
	}
}
