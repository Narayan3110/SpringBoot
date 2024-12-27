package com.library.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.dao.LibraryDAO;
import com.library.management.model.Book;

@Service
public class LibraryService {

	@Autowired
	private LibraryDAO libraryDao;

	public int addBook(Book book) {
		return libraryDao.add(book);
	}

}
