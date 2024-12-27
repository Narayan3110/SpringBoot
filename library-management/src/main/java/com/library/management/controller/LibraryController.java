package com.library.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.library.management.model.Book;
import com.library.management.service.LibraryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@GetMapping("/")
	public String getMethodName() {
		return "index";
	}

	@GetMapping("/addbook")
	public String addBook(Model m) {
		Book book = new Book();
		m.addAttribute(book);
		return "addbook";
	}

	@PostMapping("/addbook")
	public String addBook(@ModelAttribute("book") Book book) {

		libraryService.addBook(book);
		return "redirect:/index";
	}

}
