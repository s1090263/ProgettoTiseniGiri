package com.TiseniGiri.ProgettoTiseniGiri.Exceptions;

//eccezione in caso si mette un top minore di un bottom sul between.
public class ExtremesException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ExtremesException(String errorMessage) {
		super(errorMessage);
	}
}
