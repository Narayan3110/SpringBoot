package com.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.library.model.Book;

/**
 * Author : ${user} Date :30-Dec-2024 Time:12:20:23 am
 */

@Repository
public class LibraryDao {

	@Autowired
	private JdbcTemplate jt;

	public int save(Book book) {
		String sql = "insert into book(bookName , author ) values (? ,?)";

		return jt.update(sql, book.getBookName(), book.getAuthor());
	}

}
