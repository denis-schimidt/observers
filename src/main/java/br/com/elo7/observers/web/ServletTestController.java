package br.com.elo7.observers.web;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.elo7.observers.controllers.AlgumaCoisaController;

@WebServlet(urlPatterns="test/controller")
public class ServletTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BeanManager beanManager = CDI.current().getBeanManager();
		Set<Bean<?>> beans = beanManager.getBeans( AlgumaCoisaController.class );
		Bean<?> bean = beans.iterator().next();
		
		System.out.println( "Imprimindo qualifiers..." );
		
		for (Annotation annotation : bean.getQualifiers() ) {
			System.out.println( annotation );
		}
		
		System.out.println( "Imprimindo stereotypes..." );
		
		for (Class<? extends Annotation> annotation1 : bean.getStereotypes() ) {
			System.out.println( annotation1 );
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
