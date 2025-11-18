package com.nasritech.footballleague.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @Size(min = 5, max = 200, message="Team name should be between 5 and 200")
	private String teamName;
	
	@NotNull
    @Size(min = 5, max = 200, message="Team league should be between 5 and 200")
	private String teamLeague;
	
	@NotNull
	private String teamLogo;
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
   
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "user_id")
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	name = "teams_players",
	joinColumns = @JoinColumn(name = "team_id"),
	inverseJoinColumns = @JoinColumn(name = "player_id")
	)
	private List<Player> players;
	
	public Team() {
		
	}
	
	public Team(String teamName, String teamLeague, String teamLogo) {
		this.teamName = teamName;
		this.teamLeague = teamLeague;
		this.teamLogo = teamLogo;
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamLeague() {
		return teamLeague;
	}

	public void setTeamLeague(String teamLeague) {
		this.teamLeague = teamLeague;
	}

	public String getTeamLogo() {
		return teamLogo;
	}

	public void setTeamLogo(String teamLogo) {
		this.teamLogo = teamLogo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
    
	
    
	
	
}
