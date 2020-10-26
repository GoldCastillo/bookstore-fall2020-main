package com.example.bookstorefall2020.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

	public List<Book> findByTitle(String title);
}
