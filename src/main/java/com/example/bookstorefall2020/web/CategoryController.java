package com.example.bookstorefall2020.web;

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

import com.example.bookstorefall2020.domain.Book;
import com.example.bookstorefall2020.domain.BookRepository;
import com.example.bookstorefall2020.domain.Category;
import com.example.bookstorefall2020.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String getCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());

		return "categorylist";
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getCategoryRest() {
		return (List<Category>) categoryRepository.findAll();
	}

	@RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("categoryid") Long categoryid) {
		return categoryRepository.findById(categoryid);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public @ResponseBody Category saveBookRest(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@RequestMapping(value = "/addcat")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}

	@RequestMapping(value = "/savecat")
	public String save(Category category) {
		categoryRepository.save(category);
		return "redirect:categorylist";
	}

}
