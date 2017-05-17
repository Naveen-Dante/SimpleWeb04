package com.epam.simpleweb04.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.simpleweb04.command.Command;
import com.epam.simpleweb04.domain.BookInfo;
import com.epam.simpleweb04.service.BookService;
import com.epam.simpleweb04.service.exception.ServiceException;
import com.epam.simpleweb04.service.impl.BookServiceImpl;

public class BookCommand implements Command{

	private static final Logger LOGGER = Logger.getLogger(BookCommand.class);
	private static BookService service;

	public BookCommand() {
		service = BookServiceImpl.getInstance();
	}
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String language = (String) session.getAttribute("language");
		String requestURL = request.getRequestURI();
		System.out.println(requestURL);
		int bookId = Integer.parseInt(request.getParameter("button").split(":")[1]);
		System.out.println(bookId);
		try {
			BookInfo searchedBook = service.getBookInfo(bookId, language);
			if(searchedBook != null){
				request.setAttribute("book", searchedBook);
			}
			else{
				request.setAttribute("error", true);
				request.setAttribute("error_message", "Sorry! Can't Retrieve Details.");
			}
			System.out.println("Forwarding");
			request.getRequestDispatcher("book.jsp").forward(request, response);
		} catch (ServiceException e) {
			LOGGER.error("Service Exception", e);
		}
	}

}
