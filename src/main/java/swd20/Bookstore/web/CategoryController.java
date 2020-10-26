package swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.BookRepository;
import swd20.Bookstore.domain.Category;
import swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//Palauttaa kategorialistauksen
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "categorylist"; //palauttaa categorylist.html
	}
	
	//REST metodi joka palauttaa kaikki kategoriat listana
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getCategoryRest(){
		return (List<Category>) categoryRepository.findAll();
	}
	
	// REST metodi joka hakee kategorian sen IDllä
	@RequestMapping(value="categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("categoryid") Long categoryid){
		return categoryRepository.findById(categoryid);
	}
	
	//REST metodi kategorian tallentamiseen
	@RequestMapping(value="/categories", method = RequestMethod.POST)
	public @ResponseBody Category saveBookRest(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	
	//Kategorian lisäys
	@RequestMapping(value = "/addcat") //lisää tyhjän categoriaobjektin
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
		//Kategorian tallennus
		@RequestMapping(value = "/savecat")
		public String save(Category category) {
			categoryRepository.save(category);
			return "redirect:categorylist";
		}
	

}
