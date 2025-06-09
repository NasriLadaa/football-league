package com.nasritech.footballleague.models;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginUser {

	    @NotNull
	    @Size(min = 5, max = 200, message="Username must be between 5 and 200 characters")
	    private String username;
	    
	    @NotNull
	    @Size(min = 5, max = 200, message="Password must be between 5 and 200 characters")
	    private String password;
	    
	public LoginUser() {
	
	}
	
	public LoginUser(String username, String password) {
		this.password = password;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

