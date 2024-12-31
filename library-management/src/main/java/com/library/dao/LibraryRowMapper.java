package com.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.model.Book;

/**
 * Author : ${user} Date :30-Dec-2024 Time:12:35:09 am
 */

public class LibraryRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book b = new Book();
		b.setId(rs.getInt("bookId"));
		b.setBookName(rs.getString("bookName"));
		b.setAuthor(rs.getString("author"));
		return b;
	}

}
