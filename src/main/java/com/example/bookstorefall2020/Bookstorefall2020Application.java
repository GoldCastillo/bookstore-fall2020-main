package com.example.bookstorefall2020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstorefall2020.domain.Book;
import com.example.bookstorefall2020.domain.BookRepository;
import com.example.bookstorefall2020.domain.Category;
import com.example.bookstorefall2020.domain.CategoryRepository;
import com.example.bookstorefall2020.domain.User;
import com.example.bookstorefall2020.domain.UserRepository;

@SpringBootApplication
public class Bookstorefall2020Application {

	private static final Logger log = LoggerFactory.getLogger(Bookstorefall2020Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Bookstorefall2020Application.class, args);
	}

	@Bean
	public static CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		return (args) -> {

			Category category1 = new Category("Horror");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Adventure");
			Category category4 = new Category("Scifi");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);

			Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K Rowling", 1997, "951-31-1146-6", 25.00,
					categoryRepository.findByName("Adventure").get(0));
			Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J.K Rowling", 1998, "ISBN 951-31-1472-4",
					25.00, categoryRepository.findByName("Fantasy").get(0));
			Book book3 = new Book("Harry Potter and the Prisoner of Azkaban", "J.K Rowling", 1999, "ISBN 951-31-1737-5", 27.50,
					categoryRepository.findByName("Fantasy").get(0));
			Book book4 = new Book("Harry Potter and the Goblet of Fire", "J.K Rowling", 2000, "ISBN 951-31-2038-4", 27.50,
					categoryRepository.findByName("Fantasy").get(0));
			Book book5 = new Book("Harry Potter and the Order of the Phoenix", "J.K Rowling", 2003, "ISBN 951-31-2907-1", 30.00,
					categoryRepository.findByName("Fantasy").get(0));
			Book book6 = new Book("Harry Potter and the Half-Blood Prince", "J.K Rowling", 2005, "ISBN 951-31-3507-1",
					30.00, categoryRepository.findByName("Fantasy").get(0));
			Book book7 = new Book("Harry Potter and the Deathly Hallows", "J.K Rowling", 2007, "ISBN 978-951-31-4004-5",
					32.50, categoryRepository.findByName("Fantasy").get(0));

			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			bookRepository.save(book5);
			bookRepository.save(book6);
			bookRepository.save(book7);

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER",
					"user@gmail.com");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN",
					"user@gmail.com");
			userRepository.save(user1);
			userRepository.save(user2);

			log.info("Fetch all Books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			log.info("Fetch all Categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			log.info("Fetch all Users");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}

		};
	}
}