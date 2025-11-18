package com.nasritech.footballleague.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nasritech.footballleague.models.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
