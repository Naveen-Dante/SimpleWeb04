package com.epam.simpleweb04.service;

import com.epam.simpleweb04.domain.User;
import com.epam.simpleweb04.service.exception.ServiceException;

public interface LoginService {

	User getUser(String userName, String password) throws ServiceException;
	
}
