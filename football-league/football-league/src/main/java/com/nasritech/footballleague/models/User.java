package com.nasritech.footballleague.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
		 	@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		 	
		    @NotNull
		    @Size(min = 5, max = 200, message="Invalid username")
		    private String username;
		    
		    @NotNull
		    @Size(min = 5, max = 200, message="The password must be between 5 and 200 characters")
		    private String password;
		     
		    @Transient
		    @NotEmpty(message="Confirm Password is required!")
		    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
		    private String confirmPassword;
		    
		    @NotNull(message = "Phone number cannot be null")
		    @Pattern(regexp = "^0\\d{9}$", message = "Invalid phone number format")
		    private String phonenumber;
		    
		    @NotNull(message = "Email cannot be null")
		    @Email(message = "Invalid email address format")
		    private String email;
		    
		    @NotNull
		    @Size(min = 5, max = 200, message = "The address should be between 5 and 200")
		    private String address;
		    
		    // This will not allow the createdAt column to be updated after creation
		    @Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date createdAt;
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date updatedAt;
		   
		    //@ManyToOne(fetch = FetchType.LAZY)  
		    //@JoinColumn(name="team_id")
		    //private Team team;
		    
		    public User() {
		    	
		    }
		
			public User(String username, String password, String confirmPassword, String phoneNumber, String email, String address) {
			this.username = username;
			this.confirmPassword = confirmPassword;
			this.password = password;
			this.phonenumber = phoneNumber;
			this.email = email;
			this.address=address;
		}
		
		// other getters and setters removed for brevity
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

		public String getPhonenumber() {
			return phonenumber;
		}

		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

	
}
