package br.com.elo7.observers.observers;

import javax.enterprise.event.Observes;

import br.com.elo7.observers.model.Client;

public class AllOperationsObserver {

	public void logAllOperations( @Observes Client client ){
		System.out.println( "Qualquer operação -> " + client );
	}
}
