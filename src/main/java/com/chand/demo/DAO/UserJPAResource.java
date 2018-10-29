package com.chand.demo.DAO;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;

import com.chand.demo.data.Post;
import com.chand.demo.data.User;
import com.chand.demo.repository.PostRepository;
import com.chand.demo.repository.UserRepository;

@RestController
public class UserJPAResource {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@RequestMapping(value="/jpa/users", method = RequestMethod.GET)
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@RequestMapping(value="/jpa/users/{id}/posts", method = RequestMethod.GET)
	public List<Post> getUserPost(@PathVariable int id) {
		//If user exists it return value if not it comes with proper object(Optional)
		Optional<User> user = userRepo.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id-" +id);	
		
			return user.get().getPost();
	}
	
	@RequestMapping(value="/jpa/user/{id}", method = RequestMethod.GET)
	public Resource<User> getUser(@PathVariable int id) {
		//If user exists it return value if not it comes with proper object(Optional)
		Optional<User> user = userRepo.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id-" +id);	
		Resource<User> userRes = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUser());
		userRes.add(linkTo.withRel("all-users"));
			return userRes;
	}
	
	//Add new user
		@RequestMapping(value="/jpa/newUser", method =RequestMethod.POST)
		public ResponseEntity<Object> addNewUsers(@Valid @RequestBody User user){
			User userService = userRepo.save(user);
			URI location = ServletUriComponentsBuilder.
			fromCurrentRequest().path("/{id}")
			.buildAndExpand(userService.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		//Add new user
				@RequestMapping(value="/jpa/users/{id}/posts", method =RequestMethod.POST)
				public ResponseEntity<Object> addNewUsersPost(@PathVariable int id, @RequestBody Post post){
					Optional<User> userOptional = userRepo.findById(id);
					if(!userOptional.isPresent())
						throw new UserNotFoundException("id-" +id);	
					User userNew = userOptional.get();
					post.setUser(userNew);
					postRepo.save(post);
					URI location = ServletUriComponentsBuilder.
					fromCurrentRequest().path("/{id}")
					.buildAndExpand(post.getId()).toUri();
					return ResponseEntity.created(location).build();
				}
	
	@RequestMapping(value="/jpa/user/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id) {
		userRepo.deleteById(id);
	}
	
}
