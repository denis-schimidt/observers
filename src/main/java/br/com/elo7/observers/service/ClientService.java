package br.com.elo7.observers.service;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import br.com.elo7.observers.model.Client;
import br.com.elo7.observers.qualifier.Delete;
import br.com.elo7.observers.qualifier.Save;
import br.com.elo7.observers.qualifier.Update;

public class ClientService {
	
	@Inject @Delete
	private Event<Client> clientEventDelete; 
	
	@Inject @Save @Update
	private Event<Client> clientEventSave; 

	public void create(){
		Client client = new Client();
		client.setId(1);
		client.setNome( "Teste 123");
		clientEventSave.fire( client );
	}
	
	public void update(){
		Client client = new Client();
		client.setId(1);
		client.setNome( "Teste 123");
		clientEventSave.fire( client );
	}
	
	public void delete(){
		Client client = new Client();
		client.setId(1);
		clientEventDelete.fire( client );
	}
	
	@PostConstruct
	public void init(){
		System.out.println( "Inicializando ClientService..." );
	}
}
