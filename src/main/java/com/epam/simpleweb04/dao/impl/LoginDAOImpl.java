package com.epam.simpleweb04.dao.impl;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.simpleweb04.dao.ConnectionPool;
import com.epam.simpleweb04.dao.LoginDAO;
import com.epam.simpleweb04.dao.exception.DAOException;
import com.epam.simpleweb04.domain.User;

public class LoginDAOImpl implements LoginDAO {

	private static final String PASSWORD = "password";
	private static final String PHONENUMBER = "phonenumber";
	private static final String IS_ADMIN = "is_admin";
	private static final String EMAIL = "email";
	private static final String USERNAME = "username";
	private static final String LASTNAME = "lastname";
	private static final String FIRSTNAME = "firstname";
	private static volatile LoginDAOImpl instance;
	private static final ConnectionPool POOL = ConnectionPool.getPool();
	private static final String SELECT_QUERY = "SELECT * FROM userdb.user_login WHERE `username`= ?;";

	private LoginDAOImpl() {

	}

	public static LoginDAOImpl getInstance() {
		if (instance == null) {
			synchronized (LoginDAOImpl.class) {
				if (instance == null)
					instance = new LoginDAOImpl();
			}
		}
		return instance;
	}

	public User getUser(String userName, String password) throws DAOException {
		User user = null;
		Connection connection = POOL.getConnection();
		PreparedStatement selectQuery = null;
		try{
			selectQuery = connection.prepareStatement(SELECT_QUERY);
			selectQuery.setString(1, userName);
			ResultSet rs = selectQuery.executeQuery();
			while(rs.next()){
				if(rs.getString(PASSWORD).equalsIgnoreCase(password)){
					user = new User();
					user.setFirstName(rs.getString(FIRSTNAME));
					user.setLastName(rs.getString(LASTNAME));
					user.setUserName(rs.getString(USERNAME));
					user.setEmail(rs.getString(EMAIL));
					user.setType(rs.getInt(IS_ADMIN) == 0? false : true);
					user.setPhoneNumber(new BigInteger(rs.getString(PHONENUMBER)));
				}
			}
		}catch (SQLException e) {
			throw new DAOException("Unable to find the user..");
		}
		return user;
	}

}
