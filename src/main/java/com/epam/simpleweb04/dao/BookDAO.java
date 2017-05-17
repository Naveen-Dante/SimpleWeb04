package com.epam.simpleweb04.dao;

import java.util.List;

import com.epam.simpleweb04.dao.exception.DAOException;
import com.epam.simpleweb04.domain.Book;
import com.epam.simpleweb04.domain.BookInfo;

public interface BookDAO {

	List<Book> getBooks(String username, String language) throws DAOException;

	List<Book> searchBooks(String searchText, String userName, String search, String booklanguage, String language) throws DAOException;

	BookInfo searchBookInfo(int bookId, String language) throws DAOException;

	
}
