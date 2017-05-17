package com.epam.simpleweb04.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.simpleweb04.command.Command;
import com.epam.simpleweb04.domain.Book;
import com.epam.simpleweb04.domain.User;
import com.epam.simpleweb04.service.BookService;
import com.epam.simpleweb04.service.exception.ServiceException;
import com.epam.simpleweb04.service.impl.BookServiceImpl;

public class SearchCommand implements Command {

	private static final Logger LOGGER = Logger.getLogger(SearchCommand.class);
	private static BookService service;

	public SearchCommand() {
		service = BookServiceImpl.getInstance();
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String language = (String) session.getAttribute("language");
		String search = request.getParameter("select");
		String searchText = request.getParameter("searchbar");
		String booklanguage = request.getParameter("searchlanguage");
		System.out.println("User Searched this" + searchText);
		User user = (User)session.getAttribute("user");
		try {
			List<Book> searchedBook = service.searchBook(searchText, user.getUserName(), search, booklanguage, language);
			if(searchedBook != null){
				request.setAttribute("searchResult", searchedBook);
			}
			else{
				request.setAttribute("error", true);
				request.setAttribute("error_message", "Sorry! Book Not found in library.");
			}
			request.getRequestDispatcher("search.jsp").forward(request, response);
			//response.sendRedirect("searchPage");
		} catch (ServiceException e) {
			LOGGER.error("Service Exception", e);
		}

	}

}
