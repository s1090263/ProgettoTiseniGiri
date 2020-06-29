package com.TiseniGiri.ProgettoTiseniGiri.Model;

import java.util.Map;

public class Tweet {
	
	private long id; //id del tweet
	
	private String created_at; //quando il tweet è stato creato
	
	private Map<String, String> metadata; //Metadata contiene iso_language_code e result_type
	
	private User user; //oggetto della classe user che contiene l'utente che ha creato il tweet
	
	private int retweet_count; //numero delle volte che il tweet è stato retweettato
	
	private int favorite_count; //numero delle volte che il tweet è stato mipiaciato
	
	private String lang; //linguaggio del tweet (se il linguaggio non è stato riconosciuto viene scritto "und")
	
	private Entities entities; //oggetto delle entità del tweet

	public Tweet() {		
	}
	
	public Tweet(long id, String created_at, Map<String, String> metadata, User user, int retweet_count,
			int favorite_count, String lang, Entities entities) {
		super();
		this.id = id;
		this.created_at = created_at;
		this.metadata = metadata;
		this.user = user;
		this.retweet_count = retweet_count;
		this.favorite_count = favorite_count;
		this.lang = lang;
		this.entities = entities;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	
	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRetweet_count() {
		return retweet_count;
	}

	public void setRetweet_count(int retweet_count) {
		this.retweet_count = retweet_count;
	}

	public int getFavorite_count() {
		return favorite_count;
	}

	public void setFavorite_count(int favorite_count) {
		this.favorite_count = favorite_count;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Entities getEntities() {
		return entities;
	}

	public void setEntities(Entities entities) {
		this.entities = entities;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", created_at=" + created_at + ", metadata=" + metadata + ", user=" + user
				+ ", retweet_count=" + retweet_count + ", favorite_count=" + favorite_count + ", lang=" + lang
				+ ", entities=" + entities + "]";
	}	
}
