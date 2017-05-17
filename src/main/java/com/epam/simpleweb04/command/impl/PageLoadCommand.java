package com.epam.simpleweb04.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.simpleweb04.command.Command;
import com.epam.simpleweb04.domain.User;

public class PageLoadCommand implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if (session.getAttribute("isLoggedIn") == null || (Boolean) session.getAttribute("isLoggedIn") == false) {
			String requestURL = request.getRequestURI();
			String data[] = requestURL.split("/");
			System.out.println(data[data.length - 1]);
			if (data[data.length - 1].equalsIgnoreCase("user")) {
				request.getRequestDispatcher("user.jsp").forward(request, response);
			} else if (data[data.length - 1].equalsIgnoreCase("new")) {
				request.getRequestDispatcher("new.jsp").forward(request, response);
			} 
		} else {
			User user = (User) session.getAttribute("user");
			System.out.println("In loggedIn Loop");
			if (user.isAdmin() == true) {
				request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
			}
		}

	}

}
