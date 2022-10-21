package com.example.springpropsdemo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component
public class UserService {
	private static Integer userIdCounter = 0;
	private static List<User> list = new ArrayList<>();
	Supplier<UserNotFoundException> userNotFoundExceptionfunction= () -> new UserNotFoundException("User not found");
	static {
		list.add(new User(++userIdCounter, "vikas", LocalDate.now()));
		list.add(new User(++userIdCounter, "simran", LocalDate.now()));
		list.add(new User(++userIdCounter, "kiaan", LocalDate.now()));
	}

	public List<User> getUsers() {
		return list;
	}

	public User getUserById(Integer id) {
		return list.stream().filter(x -> x.getId() == id).findFirst().orElseThrow(userNotFoundExceptionfunction);
	}

	public User createUser(User user) {
		user.setId(++userIdCounter);
		list.add(user);
		return user;
	}

	public void deleteUser(Integer id) {
		list.stream().filter(x->x.getId()==id).findFirst().map(x->list.remove(x)).
		orElseThrow(userNotFoundExceptionfunction);
	}

}
