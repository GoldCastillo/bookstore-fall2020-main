package com.example.bookstorefall2020.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.bookstorefall2020.Bookstorefall2020Application;
import com.example.bookstorefall2020.domain.Category;
import com.example.bookstorefall2020.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(Bookstorefall2020Application.class);
	@Autowired
	private CategoryRepository repository;

	@Test
	public void findByTitleShouldReturnCategory() {
		List<Category> categories = repository.findByName("Adventure");

		assertThat(categories).hasSize(1);
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Fantasy");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}

	@Test
	public void DeleteCategory() {

		List<Category> category = repository.findByName("Adventure");
		repository.deleteAll(category);
		List<Category> deletedCategory = repository.findByName("Adventure");
		assertThat(deletedCategory).hasSize(0);
	}

}
