package br.edu.ufcg.splab.services.client;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ufcg.splab.dao.client.ClientDao;
import br.edu.ufcg.splab.pojo.client.Client;

@Stateless
public class ClientBean implements ClientService {

	@Inject
	private ClientDao dao;

	@Override
	public void save(Client client) {
		dao.persist(client);
	}

	@Override
	public Client update(Client client) {
		return dao.merge(client);
	}

	@Override
	public Client find(Long clientId) {
		return dao.find(clientId);
	}
}
