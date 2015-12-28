package br.com.elo7.observers.cdi.extensions;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

public class ControllerPorConvensaoExtension implements Extension {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	void configuraControllers(@Observes ProcessAnnotatedType<?> processAnnotatedType) {
		AnnotatedType<?> annotatedType = processAnnotatedType.getAnnotatedType();
		Class<?> classe = annotatedType.getJavaClass();
	
		if (classe.getPackage().getName().endsWith("controllers") || classe.getSimpleName().endsWith("Controller")) {
			processAnnotatedType.setAnnotatedType(new AnnotatedTypeControllerWrapper(annotatedType));
			
			System.out.printf( "Controlador encontrado e adicionado via CDI EXTENSION: %s\n", classe );
		}
	}
}
