package com.epam.simpleweb04.service;

import java.util.List;

import com.epam.simpleweb04.domain.Book;
import com.epam.simpleweb04.domain.BookInfo;
import com.epam.simpleweb04.service.exception.ServiceException;

public interface BookService {

	List<Book> getBooks(String username, String language) throws ServiceException;

	List<Book> searchBook(String searchText, String userName, String search, String booklanguage, String language) throws ServiceException;

	BookInfo getBookInfo(int bookId, String language) throws ServiceException;
}
