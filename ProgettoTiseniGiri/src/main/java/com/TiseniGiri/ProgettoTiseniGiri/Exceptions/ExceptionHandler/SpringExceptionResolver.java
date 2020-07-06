package com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExtremesException;
import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.NegativeNumberException;
import com.TiseniGiri.ProgettoTiseniGiri.Exceptions.OutOfReachException;

@ControllerAdvice
public class SpringExceptionResolver {

	@ExceptionHandler(NoSuchMethodException.class)
	public ResponseEntity<Error> NoSuchMethodHandler(NoSuchMethodException e){
		Error error = new Error("The method you tried to reach doesn't exist, be sure you write the right method's name and right number of parameters in your request",e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST); 	
    }	
	
	@ExceptionHandler(ClassNotFoundException.class)
	public ResponseEntity<Error> ClassNotFoundHandler(ClassNotFoundException e){
		Error error = new Error("The parameter you tried to reach doesn't exist, be sure you write the right parameter's name in your request",e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST); 	
    }
	
	@ExceptionHandler(ExtremesException.class)
	public ResponseEntity<Error> ExtremesExceptionHandler(ExtremesException e){
		Error error = new Error("The top value must be higher that the bottom value in a between filter",e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST); 	
    }	
	
	@ExceptionHandler(OutOfReachException.class)
	public ResponseEntity<Error> OutOfReachExceptionHandler(OutOfReachException e){
		Error error = new Error("The number of tweets you're tring to get exceeds the number of tweets found",e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);	
    }
	
	@ExceptionHandler(NegativeNumberException.class)
	public ResponseEntity<Error> NegativeNumberExceptionHandler(NegativeNumberException e){
		Error error = new Error("You must enter a positive number",e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);	
    }	
	
	@ExceptionHandler(ClassCastException.class)
	public ResponseEntity<Error> ClassCastExceptionHandler(ClassCastException e){
		Error error = new Error("You must enter an integer",e);
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);	
    }	
}
