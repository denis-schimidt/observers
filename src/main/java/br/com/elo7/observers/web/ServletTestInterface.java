package br.com.elo7.observers.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.elo7.observers.service.PessoaService;

@WebServlet(urlPatterns="test/interface")
public class ServletTestInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaService pessoaService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pessoaService.create();
		pessoaService.delete();
		pessoaService.update();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
