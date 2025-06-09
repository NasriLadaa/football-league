package com.nasritech.footballleague.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nasritech.footballleague.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
