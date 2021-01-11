package com.mario.api;

import com.mario.api.entity.User;
import com.mario.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUsers(){
		List<User> users = Stream.of(
				new User("v2334702-8f34-23fx-901c-037b00cef7e2","mario","mario","$2y$12$m8NRiL4Wm2/HQ2unwdNbcuqlhn4afStrTeNp4l3wBHP4KpSifJr8S","mario@gmail.com",30,new ArrayList<>()),
				new User("xad33302-8664-43ge-901c-037b3232asdd","kruno","kruno","$2y$12$m8NRiL4Wm2/HQ2unwdNbcuqlhn4afStrTeNp4l3wBHP4KpSifJr8S","kruno@gmail.com",26,new ArrayList<>())
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

}
