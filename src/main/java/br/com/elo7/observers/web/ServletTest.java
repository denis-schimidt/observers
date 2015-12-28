package br.com.elo7.observers.web;

import java.io.IOException;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.elo7.observers.service.ClientService;

@WebServlet(urlPatterns="test")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClientService clientService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clientService.create();
		clientService.delete();
		clientService.update();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
