package com.nasritech.footballleague.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nasritech.footballleague.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

}
