package com.chand.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chand.demo.DAO.UserDAO;
import com.chand.demo.data.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	
	//Get one user
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int id) {
		return userDao.findOne(id);
	}
	
	//retrieve all users
	@RequestMapping(value="/users", method =RequestMethod.GET)
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	//Add new user
	@RequestMapping(value="/newUser", method =RequestMethod.POST)
	public User addNewUsers(@RequestBody User user){
		User userService = userDao.add(user);
		return userService;
	}
}
