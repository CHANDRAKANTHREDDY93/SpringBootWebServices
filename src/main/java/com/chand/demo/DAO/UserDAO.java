package com.chand.demo.DAO;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chand.demo.data.User;

@Component
public class UserDAO {

	private static List<User> users = new ArrayList<>();
	@SuppressWarnings("unused")
	private static int userCount = 3;
	
	static {
		users.add(new User(1, "Chandrakanth Verlapally", new Date()));
		users.add(new User(2, "Pranoy", new Date()));
		users.add(new User(3, "Praneeth Reddy", new Date()));
	}
	
	//Find all users
	public List<User> findAll(){
		return users;
	}
	//Add new user
	public User add(User user){
//		int userId;
//		if(user.getId()==null) {
//			user.setId(++userCount);
//		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		
	}
	
	public User deleteOne(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
		
	}
	
	
}
