package com.TiseniGiri.ProgettoTiseniGiri.Exceptions.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Date;

public class Error {
	private Timestamp timeStamp;
    private String message;
    private String trace;
    private Exception e;
    
	public Error(String message, Exception e) {
        this.message = message; 
        this.e = e;
    }
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTrace() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		trace = sw.toString();
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;	
	}

	public Timestamp getTimeStamp() {
		Date date= new Date();
		long time = date.getTime();
		timeStamp = new Timestamp(time);
		return timeStamp;
	}
	
}
