package com.chand.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chand.demo.DAO.UserDAO;
import com.chand.demo.DAO.UserNotFoundException;
import com.chand.demo.data.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	
	//Get one user
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int id) {
		User user =userDao.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id"+ id);
			return user;
	}
	
	//retrieve all users
	@RequestMapping(value="/users", method =RequestMethod.GET)
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	
	//Add new user
	@RequestMapping(value="/newUser", method =RequestMethod.POST)
	public ResponseEntity<Object> addNewUsers(@RequestBody User user){
		User userService = userDao.add(user);
		URI location = ServletUriComponentsBuilder.
		fromCurrentRequest().path("/{id}")
		.buildAndExpand(userService.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
