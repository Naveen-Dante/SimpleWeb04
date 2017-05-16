package com.epam.simpleweb04.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.simpleweb04.command.CommandProvider;
import com.epam.simpleweb04.utility.Utility;

/**
 * Servlet implementation class SimpleWebAppController
 */
public class SimpleWebAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final CommandProvider PROVIDER = new CommandProvider();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SimpleWebAppController() {
		
	}

	@Override
	public void init() throws ServletException {
		Utility.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PROVIDER.getCommand("get").execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("button");
		PROVIDER.getCommand(operation).execute(request, response);
	}

}
