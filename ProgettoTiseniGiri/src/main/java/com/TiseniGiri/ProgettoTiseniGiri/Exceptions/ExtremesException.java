package com.TiseniGiri.ProgettoTiseniGiri.Exceptions;

//eccezione che gestisce il between
public class ExtremesException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
		
	public ExtremesException(String errorMessage) {
		super(errorMessage);
	}
}
