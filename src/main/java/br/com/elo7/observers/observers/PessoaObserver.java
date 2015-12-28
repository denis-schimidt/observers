package br.com.elo7.observers.observers;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Vetoed;
import javax.enterprise.inject.spi.EventMetadata;

import br.com.elo7.observers.model.Identifiable;
import br.com.elo7.observers.qualifier.Delete;
import br.com.elo7.observers.qualifier.Save;
import br.com.elo7.observers.qualifier.Update;

@Vetoed
public class PessoaObserver {

	public void logUpdate( @Observes @Delete Identifiable identifiable, EventMetadata eventMetadata ){		
		System.out.printf( "Operação Delete (%s) -> %s\n", eventMetadata.getQualifiers().toString(), identifiable.toString() );
	}
	
	public void logSave( @Observes @Save @Update Identifiable identifiable, EventMetadata eventMetadata ){
		System.out.printf( "Operação Save (%s) -> %s\n", eventMetadata.getQualifiers(), identifiable.toString() );
	}
}
