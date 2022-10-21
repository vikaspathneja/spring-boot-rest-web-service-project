package com.example.springpropsdemo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "users")
public class UserController {

	private UserService userService;

	public UserController(UserService service) {
		// TODO Auto-generated constructor stub
		userService = service;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) {
		User userById = userService.getUserById(id);
		if (userById == null)
			return ResponseEntity.notFound().build();
		//below else if logic is to only test common excpetion message along with custom http status is being thrown or not refer CustomExceptionWithCustomMessage class
		else if(userById.getId()%5==0)
			throw new NullPointerException("user id is invalid");
		else
			return ResponseEntity.ok().body(userById);
	}

	@PostMapping()
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User createdUser = userService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).body(createdUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	//HATEOS METHOD
	@GetMapping(path="/gethateosuser")
	public EntityModel<User> getHateosUser(){
		WebMvcLinkBuilder lb=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		EntityModel<User> entityUser=EntityModel.of(userService.getUsers().get(0));
		entityUser.add(lb.withRel("all-users"));
 		return entityUser;
	}
	
	
}
