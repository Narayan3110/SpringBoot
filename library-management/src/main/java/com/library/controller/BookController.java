package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.model.Book;
import com.library.services.LibraryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * Author : ${user} Date :29-Dec-2024 Time:11:22:20 pm
 */
@Controller
public class BookController 
{
	@Autowired
	private LibraryService libServ;
	
	@GetMapping("/")
	public String getMethodName() {
		return "index";
	}
	
	@GetMapping("/new")
	public String showFormToAddBook(Model m) {
		Book book = new Book();
		m.addAttribute(book);
		return "new";
	}
	
	@PostMapping("/books")
	public String saveBook(@ModelAttribute("book") Book b) {
		libServ.saveBook(b);
		return "redirect:/";
		
	}
	
	
	
}
