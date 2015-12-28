package br.com.elo7.observers.cdi.extensions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.enterprise.inject.spi.ObserverMethod;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ObserverMethodWrapper<T> implements ObserverMethod<T> {
	private ObserverMethod<T> wrapper;
	private ExecutorService executor;

	ObserverMethodWrapper(ObserverMethod<T> wrapper) {
		this.wrapper = wrapper;
	}

	public Class<?> getBeanClass() {
		return wrapper.getBeanClass();
	}

	public Type getObservedType() {
		return wrapper.getObservedType();
	}

	public Set<Annotation> getObservedQualifiers() {
		return wrapper.getObservedQualifiers();
	}

	public Reception getReception() {
		return wrapper.getReception();
	}

	public TransactionPhase getTransactionPhase() {
		return wrapper.getTransactionPhase();
	}

	@SuppressWarnings("unchecked")
	public void notify(Object event) {
		getExecutor().execute( ()->{ wrapper.notify( (T) event ); });
	}

	private ExecutorService getExecutor() {
		if (executor != null) {
			return executor;
		}
		try {
			Context ctx = new InitialContext();
			executor = (ManagedExecutorService) ctx.lookup("java:jboss/ee/concurrency/executor/default");
			
		} catch (Exception e) {
			System.out.printf("Erro ao buscar o ManagedExecutorService (JSR 236) -> %s\n", e);
			System.out.println("Usando implementação simples de newCachedThreadPool()" );
			
			executor = Executors.newCachedThreadPool();
		}
		
		return executor;
	}
}
