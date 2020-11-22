package com.MyBookstoreAdmin;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.MyBookstoreAdmin.model.User;
import com.MyBookstoreAdmin.model.security.Role;
import com.MyBookstoreAdmin.model.security.UserRole;
import com.MyBookstoreAdmin.service.UserService;
import com.MyBookstoreAdmin.utility.SecurityUtility;

@SpringBootApplication
public class MyBookstoreAdminApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(MyBookstoreAdminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmail("admin@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(0);
		role1.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);
		
//		Book b1=new Book();
//		b1.setTitle("The Intelligent Investor");
//		b1.setAuthor("Benjamin Graham");
//		b1.setPublisher("HarperCollins");
//		b1.setPublicationDate("2009-03-17");
//		b1.setLanguage("english");
//		b1.setCategory("Management");
//		b1.setNumberOfPages(833);
//		b1.setFormat("paperback");
//		b1.setIsbn(9780060);
//		b1.setShippingWeight(0.55);
//		b1.setListPrice(2500.00);
//		b1.setOurPrice(2200.00);
//		b1.setActive(true);
//		b1.setDescription("The greatest investment advisor of the twentieth century, Benjamin Graham taught and inspired people worldwide. Graham's philosophy of “value investing”—which shields investors from substantial error and teaches them to develop long-term strategies—has made The Intelligent Investor the stock market bible ever since its original publication in 1949.Vital and indispensable, The Intelligent Investor is the most important book you will ever read on how to reach your financial goals."); 
//		b1.setInStockNumber(9);
//		bookService.save(b1);
		
	}
}
