package br.com.elo7.observers.cdi.extensions;

import java.lang.reflect.Method;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ObserverMethod;

import org.jboss.weld.bean.builtin.BeanManagerProxy;
import org.jboss.weld.event.ObserverMethodImpl;
import org.jboss.weld.injection.MethodInjectionPoint;
import org.jboss.weld.manager.BeanManagerImpl;

public class EventoAssincronoExtension implements Extension {

	void alterarMetodoObserver( @Observes AfterBeanDiscovery event, BeanManager manager ){
		BeanManagerImpl beanManagerImpl = ((BeanManagerProxy) manager).delegate();
		
		for (ObserverMethod<?> observerMethod : beanManagerImpl.getObservers()) {
			ObserverMethodImpl<?,?> observerMethodImpl=(ObserverMethodImpl<?,?>) observerMethod;
			MethodInjectionPoint<?,?> methodInjectionPoint = observerMethodImpl.getMethod();
			AnnotatedMethod<?> annotatedMethod = methodInjectionPoint.getAnnotated();
			Method method = annotatedMethod.getJavaMember();
			
			System.out.println( method );
			System.out.println( method.isAnnotationPresent( Assincrono.class ) );
			
			if( method.isAnnotationPresent( Assincrono.class ) ){
				beanManagerImpl.getObservers().remove( observerMethod );
				event.addObserverMethod(new ObserverMethodWrapper<>( observerMethod ) );
			}
		}
	}
}
