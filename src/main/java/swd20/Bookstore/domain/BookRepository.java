package swd20.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {

	//CrudRepositorista periytyy kaikki tavalliset tietojenkäsittelyn metodit
	//kuten findAll() findById save() ja deleteById
	
	//uusi find-metodin määrittely
	public List<Book> findByTitle(String title);
}
