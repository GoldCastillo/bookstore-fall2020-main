package com.example.bookstorefall2020.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	public List<Category> findByName(String name);

}
