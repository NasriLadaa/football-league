package com.nasritech.footballleague.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasritech.footballleague.models.Address;
import com.nasritech.footballleague.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository adddressRepo;
	
	public void saveAddress(Address address) {
		adddressRepo.save(address);
	}
	
}
