package swd20.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository <Category, Long> {

	//CrudRepositorista periytyy kaikki tavalliset tietojenkäsittelyn metodit
	//kuten findAll() findById save() ja deleteById
	
	//uusi find metodi
	public List<Category> findByName(String name);
	
}
