package com.TiseniGiri.ProgettoTiseniGiri.Model;

public class Metadata {
	
	private String iso_language_code; //codice del linguaggio identificato (se non viene identificato è und)
	
	private String result_type; //tipo del risultato (recent, popular)
	
	public Metadata(String iso_language_code, String result_type) {
		super();
		this.iso_language_code = iso_language_code;
		this.result_type = result_type;
	}

	public String getIso_language_code() {
		return iso_language_code;
	}

	public void setIso_language_code(String iso_language_code) {
		this.iso_language_code = iso_language_code;
	}

	public String getResult_type() {
		return result_type;
	}

	public void setResult_type(String result_type) {
		this.result_type = result_type;
	}

	@Override
	public String toString() {
		return "Metadata [iso_language_code=" + iso_language_code + ", result_type=" + result_type + "]";
	}
	
	
	
}
