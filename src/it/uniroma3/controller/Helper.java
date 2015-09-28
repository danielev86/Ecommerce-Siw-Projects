package it.uniroma3.controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public abstract class Helper {
	
	protected HttpServletRequest request;
	
	public Helper(HttpServletRequest request)throws ServletException{
		
		this.request=request;
		
	}
	
	public abstract boolean convalida();

}
