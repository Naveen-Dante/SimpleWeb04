package com.epam.simpleweb04.dao;

import com.epam.simpleweb04.dao.exception.DAOException;
import com.epam.simpleweb04.domain.User;

public interface NewUserDAO {

	boolean addNewUser(User user, String password) throws DAOException;

}
