package br.edu.ufcg.splab.services.client;

import javax.ejb.Local;

import br.edu.ufcg.splab.pojo.client.Client;

@Local
public interface ClientService {

	void save(Client client);

	Client update(Client client);

	Client find(Long clientId);
}
