package com.library.management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.library.management.model.Book;

@Repository
public class LibraryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int add(Book book) {
		String query = "INSERT INTO lib(bookName,author) VALUES (?,?)";
		return jdbcTemplate.update(query, book.getBookName(), book.getAuthor());
	}
}
