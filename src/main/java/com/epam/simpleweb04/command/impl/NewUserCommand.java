package com.epam.simpleweb04.command.impl;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.simpleweb04.command.Command;
import com.epam.simpleweb04.domain.User;
import com.epam.simpleweb04.service.NewUserService;
import com.epam.simpleweb04.service.exception.ServiceException;
import com.epam.simpleweb04.service.impl.NewUserServiceImpl;

public class NewUserCommand implements Command {
	private static NewUserService service;
	private static final Logger LOGGER = Logger.getLogger(NewUserCommand.class);

	public NewUserCommand() {
		service = NewUserServiceImpl.getInstance();
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = new User();
		user.setFirstName(request.getParameter("first-name"));
		user.setLastName(request.getParameter("last-name"));
		user.setUserName(request.getParameter("user-name"));
		user.setPhoneNumber(new BigInteger(request.getParameter("phone")));
		user.setType(false);
		user.setEmail(request.getParameter("email"));
		String password = request.getParameter("password");
		boolean success = false;
		String errorMsg = null;
		response.setContentType("text/html");
		try {
			success = service.addNewUser(user, password);
			if (!success) {
				errorMsg = "UserName Not Available.. Please try Again..";
				request.setAttribute("error", true);
				request.setAttribute("error_message", errorMsg);
				request.getRequestDispatcher("new.jsp").forward(request, response);
			} else {
				session.setAttribute("user", user);
				session.setAttribute("isLoggedIn", true);
				request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
			}
		} catch (ServiceException e) {
			errorMsg = "Sorry but we can not add the User: " + user.getFirstName() + " " + user.getLastName()
					+ ", due to technical difficulties. Please try later.";
			LOGGER.info("Unable to add new user to DB.", e);
		}
	}

}
