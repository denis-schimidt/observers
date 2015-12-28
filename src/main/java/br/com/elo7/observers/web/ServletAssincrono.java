package br.com.elo7.observers.web;

import java.io.IOException;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.elo7.observers.model.Client;
import br.com.elo7.observers.model.Identifiable;
import br.com.elo7.observers.qualifier.Delete;
import br.com.elo7.observers.qualifier.Save;
import br.com.elo7.observers.qualifier.Update;

@WebServlet(urlPatterns="test/async")
public class ServletAssincrono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject @Delete 
	private Event<Identifiable> eventDelete; 
	
	@Inject @Save @Update
	private Event<Identifiable> eventSave; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		eventDelete.fire( new Client());
		eventSave.fire( new Client());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
