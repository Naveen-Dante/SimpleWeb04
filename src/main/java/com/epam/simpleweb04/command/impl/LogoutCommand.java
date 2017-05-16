package com.epam.simpleweb04.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.simpleweb04.command.Command;

public class LogoutCommand implements Command {
	
	private static final Logger LOGGER = Logger.getLogger(LogoutCommand.class);

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		try {
			request.getRequestDispatcher("").forward(request, response);
		} catch (ServletException e) {
			LOGGER.error("Unable to perform Operation.",e);
		}
		//response.sendRedirect("");
	}

}
