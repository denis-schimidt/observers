package br.com.elo7.observers.observers;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.EventMetadata;

import br.com.elo7.observers.cdi.extensions.Assincrono;
import br.com.elo7.observers.model.Identifiable;
import br.com.elo7.observers.qualifier.Delete;
import br.com.elo7.observers.qualifier.Save;
import br.com.elo7.observers.qualifier.Update;

public class PessoaObserverAssincrono {

	@Assincrono
	public void logUpdate( @Observes @Delete Identifiable identifiable, EventMetadata eventMetadata ){
		
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf( "Operação Delete (%s) -> %s\n", eventMetadata.getQualifiers().toString(), identifiable.toString() );
	}
	
	@Assincrono
	public void logSave( @Observes @Save @Update Identifiable identifiable, EventMetadata eventMetadata ){
		
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf( "Operação Save (%s) -> %s\n", eventMetadata.getQualifiers(), identifiable.toString() );
	}
}
