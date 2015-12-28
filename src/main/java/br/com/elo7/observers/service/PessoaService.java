package br.com.elo7.observers.service;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import br.com.elo7.observers.model.Client;
import br.com.elo7.observers.model.Identifiable;
import br.com.elo7.observers.model.User;
import br.com.elo7.observers.qualifier.Delete;
import br.com.elo7.observers.qualifier.Save;
import br.com.elo7.observers.qualifier.Update;

public class PessoaService {

	@Inject @Delete
	private Event<Identifiable> eventDelete; 
	
	@Inject @Save @Update
	private Event<Identifiable> eventSave; 
	
	public void create(){
		Client client = new Client();
		client.setId(1);
		client.setNome( "Teste 123");
		eventSave.fire( client );
	}
	
	public void update(){
		User user = new User();
		user.setId( 10 );
		user.setNome( "Fulano da Silva");
		eventSave.fire(user);
	}
	
	public void delete(){
		Client client = new Client();
		client.setId(1);
		eventDelete.fire( client );
	}
}
