package com.nasritech.footballleague.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nasritech.footballleague.models.LoginUser;
import com.nasritech.footballleague.models.Team;
import com.nasritech.footballleague.models.User;
import com.nasritech.footballleague.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User Login(LoginUser userLogin, BindingResult bindingResult) {
		
		// Find user in the DB by email
		Optional<User> loginUser = userRepo.findByUsername(userLogin.getUsername());
		if (loginUser.isEmpty()) {
			bindingResult.rejectValue( "username", "Not Found" , "Username does not exist" );
			return null;
		}
		
		// Get the user object
		User user = loginUser.get();
		
		 // Reject if BCrypt password match fails
		if (!BCrypt.checkpw(userLogin.getPassword(), user.getPassword())) {
			bindingResult.rejectValue("password", "invalid" , "Username or Password does not exist");
		}
		
		// Return null if result has errors
    	if (bindingResult.hasErrors()) {
    		return null;
    	}
    	else {
    		return user;
    	}
	}
	
	public User register(User user , BindingResult bindingResult) {
		// Check if email is already taken
		Optional<User> potentialNewUser = userRepo.findByUsername(user.getUsername());
		if (potentialNewUser.isPresent()) {
			bindingResult.rejectValue("username", "Email.Exsists", "This Username already exists!" );
		}
		
    // Check if passwords match
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			bindingResult.rejectValue("password", "Not.Match", "Passwords not match!" );
		}
		
    // Return null if result has errors
		if (bindingResult.hasErrors()) {
			return null;
		}

    // Hash and set password, save user to database
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);
		return userRepo.save(user);

	}
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	public Optional<User> getUser(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
}
