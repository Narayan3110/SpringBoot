package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.LibraryDao;
import com.library.model.Book;

/**
 * Author : ${user} Date :30-Dec-2024 Time:12:18:03 am
 */

@Service
public class LibraryService {

	@Autowired
	private LibraryDao librarydao;

	public int saveBook(Book book) {
		return librarydao.save(book);
	}

}
