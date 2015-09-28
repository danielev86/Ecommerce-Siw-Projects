package it.uniroma3.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import it.uniroma3.model.Cliente;
import it.uniroma3.model.Amministratore;

/**
 * Servlet Filter implementation class FilterLogin
 */
public class FilterLogin implements Filter {
	
	private ServletContext application;

    /**
     * Default constructor. 
     */
    public FilterLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		Amministratore amministratore = (Amministratore) session.getAttribute("amministratore");
		if((cliente ==null) && (amministratore==null)){
			RequestDispatcher rd = application.getRequestDispatcher("/login.do");
			rd.forward(request, response);
		}else chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		application = fConfig.getServletContext();
	}

}
