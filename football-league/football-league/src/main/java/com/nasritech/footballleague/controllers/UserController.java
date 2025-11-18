package com.nasritech.footballleague.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasritech.footballleague.models.Address;
import com.nasritech.footballleague.models.Player;
import com.nasritech.footballleague.models.Team;
import com.nasritech.footballleague.models.User;
import com.nasritech.footballleague.services.AddressService;
import com.nasritech.footballleague.services.PlayerService;
import com.nasritech.footballleague.services.TeamService;
import com.nasritech.footballleague.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired 
	private AddressService addressService;
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/add")
	public void addTeam() {
		long id = 1;
		Team team = new Team("Chelsea", "England" , "");
		Team team2 = new Team("Barcalona", "Spain" , "");
		User user = userService.getUser(id).orElse(null);


		team.setUser(user);
		teamService.saveTeam(team);
		
		/*
		 *   
		// Set owner side
    	team1.setUser(user);
    	team2.setUser(user);

    	// Set inverse side
    	user.getTeams().add(team1);
    	user.getTeams().add(team2);

    	// Saving user will save the teams too because of cascade = ALL
    	userService.saveUser(user);
		 */
	}
	
	@GetMapping("/add/address")
	public void addAddress() {
		long id = 1;
		Address address = new Address("Palestine", "Ramallah" ,"Main Street");
		User user = userService.getUser(id).orElse(null);
		
		address.setUser(user);
		addressService.saveAddress(address);
	}
	
	@GetMapping("/add/team/player")
	public void addPlayerTeam() {
		long player_id = 1;
		long team_id = 2;
		Player player = playerService.findPlayer(player_id).get();
		Team team = teamService.findTeam(team_id).get();
		
		team.getPlayers().add(player);
		teamService.saveTeam(team);
		
		//player.getTeams().add(team);
		//playerService.savePlayer(player);
	}
	
	@GetMapping("/add/player")
	public void addPlayer() {
		Player player = new Player("Ronaldo" , "Da Lima");		
		playerService.savePlayer(player);
	}
}
