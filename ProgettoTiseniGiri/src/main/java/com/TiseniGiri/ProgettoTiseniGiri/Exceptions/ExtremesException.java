package com.TiseniGiri.ProgettoTiseniGiri.Exceptions;

public class ExtremesException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
		
	public ExtremesException(String errorMessage) {
		super(errorMessage);
	}
}
