package br.com.elo7.observers.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="cadastrar")
public class CadastroServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isErro = request.getParameter("erro");
		
		if( isErro != null && Boolean.parseBoolean(isErro) ){
			request.getParameterMap().keySet().forEach( k -> request.setAttribute( k, request.getParameter( k ) ) );
		}

		request.getRequestDispatcher( "index.jsp" ).forward(request, response);
	}
}
