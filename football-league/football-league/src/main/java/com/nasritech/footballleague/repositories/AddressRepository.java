package com.nasritech.footballleague.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nasritech.footballleague.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{

}
