package com.MyBookstoreUser;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.MyBookstoreUser.model.User;
import com.MyBookstoreUser.model.security.Role;
import com.MyBookstoreUser.model.security.UserRole;
import com.MyBookstoreUser.service.UserService;
import com.MyBookstoreUser.utility.SecurityUtility;

@SpringBootApplication
public class MyBookstoreUserApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(MyBookstoreUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("Abhishek");
		user1.setLastName("Shah");
		user1.setUsername("abhi");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("1234"));
		user1.setEmail("abcd1010.abcd1999@gmail.com");
		user1.setPhone("8200856019");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);
		
		
//		User user2 = new User();
//		user2.setFirstName("Priyal");
//		user2.setLastName("Shah");
//		user2.setUsername("priyal");
//		user2.setPassword(SecurityUtility.passwordEncoder().encode("1234"));
//		user2.setEmail("priyaldshah99@gmail.com");
//		user2.setPhone("9978486115");
//		Set<UserRole> userRoles2 = new HashSet<>();
//		Role role2= new Role();
//		role2.setRoleId(1);
//		role2.setName("ROLE_USER");
//		userRoles.add(new UserRole(user2, role1));
//		userService.createUser(user2, userRoles2);
		
	}

}
