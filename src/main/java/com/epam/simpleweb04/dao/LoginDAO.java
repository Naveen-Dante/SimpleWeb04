package com.epam.simpleweb04.dao;

import com.epam.simpleweb04.dao.exception.DAOException;
import com.epam.simpleweb04.domain.User;

public interface LoginDAO {

	User getUser(String userName, String password) throws DAOException;

}
