package com.epam.simpleweb04.service.impl;

import com.epam.simpleweb04.dao.LoginDAO;
import com.epam.simpleweb04.dao.exception.DAOException;
import com.epam.simpleweb04.dao.impl.LoginDAOImpl;
import com.epam.simpleweb04.domain.User;
import com.epam.simpleweb04.service.LoginService;
import com.epam.simpleweb04.service.exception.ServiceException;

public class LoginServiceImpl implements LoginService {

	private static volatile LoginServiceImpl instance;
	private static LoginDAO dao;

	private LoginServiceImpl() {
		dao = LoginDAOImpl.getInstance();
	}

	public static LoginServiceImpl getInstance() {
		if (instance == null) {
			synchronized (LoginServiceImpl.class) {
				if (instance == null)
					instance = new LoginServiceImpl();
			}
		}
		return instance;
	}

	public User getUser(String userName, String password) throws ServiceException {
		User user = null;
		try {
			user = dao.getUser(userName, password);
		} catch (DAOException e) {
			throw new ServiceException("Unable to get the UserData.");
		}
		return user;
	}

}
