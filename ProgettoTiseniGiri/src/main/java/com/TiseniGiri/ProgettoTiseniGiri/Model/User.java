package com.TiseniGiri.ProgettoTiseniGiri.Model;

public class User {
	
	private String id; //id dell'utente
	
	private String name; //nome dell'utente
	
	private int followers_count; //numero followers utente
	
	private int friends_count; //numero amici utente
	
	private int favourites_count; //numero di tweet a cui l'utente ha messo mi piace
	
	private int statuses_count; //numero di tweet emessi dall'utente
	
	private boolean verified; //indica se l'utente ha l'account verificato

	public User() {
	}
	
	public User(String id, String name, int followers_count, int friends_count, int favourites_count,
			int statuses_count, boolean verified) {
		super();
		this.id = id;
		this.name = name;
		this.followers_count = followers_count;
		this.friends_count = friends_count;
		this.favourites_count = favourites_count;
		this.statuses_count = statuses_count;
		this.verified = verified;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(int followers_count) {
		this.followers_count = followers_count;
	}

	public int getFriends_count() {
		return friends_count;
	}

	public void setFriends_count(int friends_count) {
		this.friends_count = friends_count;
	}

	public int getFavourites_count() {
		return favourites_count;
	}

	public void setFavourites_count(int favourites_count) {
		this.favourites_count = favourites_count;
	}

	public int getStatuses_count() {
		return statuses_count;
	}

	public void setStatuses_count(int statuses_count) {
		this.statuses_count = statuses_count;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", followers_count=" + followers_count + ", friends_count="
				+ friends_count + ", favourites_count=" + favourites_count + ", statuses_count=" + statuses_count
				+ ", verified=" + verified + "]";
	}	
}
