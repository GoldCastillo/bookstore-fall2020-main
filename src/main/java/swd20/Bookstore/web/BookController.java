package swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.BookRepository;
import swd20.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Kirajutumis sivu
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	//palauttaa kirjalistauksen
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
		//lisätään autolista model-olion mappiin avainarvolla templatea varten
		model.addAttribute("books", bookRepository.findAll());
		
		return "booklist"; //palautetaan Books.html
	}
	
	//REST metodi joka palauttaa kaikki kirjat listana (JSON)
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) bookRepository.findAll();
	}
	
	//REST metodi joka hakee kirjan sen IDllä
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id){
		return bookRepository.findById(id);
	}
	
	//REST metodi uuden kirjan tallentamiseen
	@RequestMapping(value="books", method = RequestMethod.POST)
	public @ResponseBody Book saveBookRest (@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	
	
	//Kirjan poisto
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	//Kirjan lisäys
	@RequestMapping(value = "/add") //tekee tyhjän kirja objektin
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	//Kirjan tallennus
	@RequestMapping(value = "/save")
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}
	
	//Kirjan muokkaus
	@RequestMapping(value= "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}
	
	//http://localhost:8080/index
	@RequestMapping("/index")
	public String Bookstore() {
		return "booklist";
	}
	

}
