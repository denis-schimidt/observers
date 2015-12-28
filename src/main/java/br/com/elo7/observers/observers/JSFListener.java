package br.com.elo7.observers.observers;

import javax.enterprise.event.Event;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.elo7.observers.qualifier.After;
import br.com.elo7.observers.qualifier.RestoreView;

public class JSFListener implements PhaseListener{
	private static final long serialVersionUID = 1L;

	@Inject @After @RestoreView
	private Event<PhaseEvent> facesEvent;
	
	@Override
	public void afterPhase(PhaseEvent event) {
		facesEvent.fire(event);
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
