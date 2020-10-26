package com.example.bookstorefall2020.test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.bookstorefall2020.domain.Book;
import com.example.bookstorefall2020.domain.BookRepository;
import com.example.bookstorefall2020.domain.Category;


@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Harry Potter and the Prisoner of Azkaban");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("J.K Rowling");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Harry Potter and the Champer of Secrets", "J.K Rowling", 1998, "0-7475-3849-2", 9.0,
				new Category("Fantasy"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void DeleteBook() {
		List<Book> books = repository.findByTitle("Harry Potter and the Prisoner of Azkaban");
		repository.deleteById(books.get(0).getId());
		List<Book> deletedBook = repository.findByTitle("Harry Potter and the Prisoner of Azkaban");
		assertThat(deletedBook).hasSize(0);
	}
}
