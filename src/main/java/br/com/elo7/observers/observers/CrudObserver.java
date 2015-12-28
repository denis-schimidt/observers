package br.com.elo7.observers.observers;

import javax.enterprise.event.Observes;

import br.com.elo7.observers.model.Client;
import br.com.elo7.observers.qualifier.Delete;
import br.com.elo7.observers.qualifier.Save;

public class CrudObserver {

	public void logUpdate( @Observes @Delete Client client ){
		System.out.printf( "CrudObserver - Operação Delete -> %s\n", client );
	}
	
	public void logSave( @Observes @Save Client client){
		System.out.printf( "CrudObserver - Operação Save -> %s\n", client );
	}
}
