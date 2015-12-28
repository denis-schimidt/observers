package br.com.elo7.observers.cdi.extensions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.spi.AnnotatedConstructor;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.util.AnnotationLiteral;

import br.com.elo7.observers.stereotypes.Controller;

public class AnnotatedTypeControllerWrapper<T> implements AnnotatedType<T> {
	private AnnotatedType<T> wrapped;

	AnnotatedTypeControllerWrapper(AnnotatedType<T> annotatedType) {
		this.wrapped = annotatedType;
	}

	public Type getBaseType() {
		return wrapped.getBaseType();
	}

	public Set<Type> getTypeClosure() {
		return wrapped.getTypeClosure();
	}

	@SuppressWarnings("hiding")
	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
		return wrapped.getAnnotation(annotationType);
	}

	@SuppressWarnings("serial")
	public Set<Annotation> getAnnotations() {
		Set<Annotation> annotations = new HashSet<>(wrapped.getAnnotations());
		annotations.add(new AnnotationLiteral<Controller>() {});
		
		return annotations;
	}

	@Override
	public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
		return wrapped.isAnnotationPresent(annotationType);
	}

	@Override
	public Class<T> getJavaClass() {
		return wrapped.getJavaClass();
	}

	public Set<AnnotatedConstructor<T>> getConstructors() {
		return wrapped.getConstructors();
	}

	public Set<AnnotatedMethod<? super T>> getMethods() {
		return wrapped.getMethods();
	}

	public Set<AnnotatedField<? super T>> getFields() {
		return wrapped.getFields();
	}
}
