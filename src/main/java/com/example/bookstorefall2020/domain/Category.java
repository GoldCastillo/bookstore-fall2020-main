package com.example.bookstorefall2020.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	//
	@JsonIgnoreProperties("categories")
	private List<Book> books;

	public Category(String name) {

		this.name = name;
	}

	public Category() {

	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}

}
