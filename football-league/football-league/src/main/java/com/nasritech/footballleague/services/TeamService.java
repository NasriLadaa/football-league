package com.nasritech.footballleague.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasritech.footballleague.models.Team;
import com.nasritech.footballleague.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepo;
	
	public void saveTeam(Team team) {
		teamRepo.save(team);
	}
}
