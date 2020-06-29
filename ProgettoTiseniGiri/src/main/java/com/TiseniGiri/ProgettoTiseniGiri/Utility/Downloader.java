package com.TiseniGiri.ProgettoTiseniGiri.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Downloader {
	
	public static String downloadData (String url) {
		
		String data = "";
		String line = "";		
			
		try {
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream input = openConnection.getInputStream();
				
			try {
					InputStreamReader inputR = new InputStreamReader( input );
					BufferedReader buffered = new BufferedReader( inputR );
					  
					while ( ( line = buffered.readLine() ) != null ) {
						data+= line;
						}
					} catch (IOException e) {
						System.out.println("Error: IOException found");	
					} finally {
						input.close();
					}
			}
					
			catch (IOException e) {
				
				System.out.println("Error: IOException found");
			}
		
		return data;
	}
}
