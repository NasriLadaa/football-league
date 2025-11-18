package com.nasritech.footballleague.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasritech.footballleague.models.Player;
import com.nasritech.footballleague.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepo;
	
	public Optional<Player> findPlayer(long id){
		return playerRepo.findById(id);
	}
	
	public void savePlayer(Player player) {
		playerRepo.save(player);
	}
}
