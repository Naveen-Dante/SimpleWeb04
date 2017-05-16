package com.epam.simpleweb04.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.simpleweb04.dao.ConnectionPool;
import com.epam.simpleweb04.dao.NewUserDAO;
import com.epam.simpleweb04.dao.exception.DAOException;
import com.epam.simpleweb04.dao.utility.Utility;
import com.epam.simpleweb04.domain.User;

public class NewUserDAOImpl implements NewUserDAO {

	private static final String USER = "user";
	private static volatile NewUserDAOImpl instance;
	private static final ConnectionPool POOL = ConnectionPool.getPool();
	private static final String INSERT_QUERY = "INSERT INTO `userdb`.`user_login` "
			+ "(`username`, `firstname`, `lastname`, `email`, `password`, `phonenumber`, `is_admin`) "
			+ "VALUES ( ?, ?, ?, ?, ?, ?, ?);";
	private static final String IS_USER_NAME_QUERY = "SELECT EXISTS ("
			+ "SELECT 1 FROM `user_login` WHERE `username` = ?)" + " AS user ";

	private NewUserDAOImpl() {

	}

	public static NewUserDAOImpl getInstance() {
		if (instance == null) {
			synchronized (NewUserDAOImpl.class) {
				if (instance == null)
					instance = new NewUserDAOImpl();
			}
		}
		return instance;
	}

	public boolean addNewUser(User user, String password) throws DAOException {
		// TODO Auto-generated method stub
		boolean success = false;
		Connection connection = POOL.getConnection();
		PreparedStatement insertQuery = null;
		try {
			insertQuery = connection.prepareStatement(INSERT_QUERY);
			if (isUser(user, connection)) {
				insertQuery.setString(1, user.getUserName());
				insertQuery.setString(2, user.getFirstName());
				insertQuery.setString(3, user.getLastName());
				insertQuery.setString(4, user.getEmail());
				insertQuery.setString(5, password);
				insertQuery.setString(6, user.getPhoneNumber().toString());
				insertQuery.setInt(7, user.isAdmin() == true ? 1 : 0);
				success = (insertQuery.executeUpdate() > 0 ? true : false);
			}
		} catch (SQLException e) {
			throw new DAOException("Unable to Create New User", e);
		} finally {
			Utility.closeStatement(insertQuery);
			Utility.closeConnection(connection);
		}
		return success;
	}

	private boolean isUser(User user, Connection connection) throws SQLException {
		boolean isAvailable = true;
		PreparedStatement validateExistanceQuery = null;
		validateExistanceQuery = connection.prepareStatement(IS_USER_NAME_QUERY);
		validateExistanceQuery.setString(1, user.getUserName());
		ResultSet rs = validateExistanceQuery.executeQuery();
		while (rs.next()) {
			if (rs.getInt(USER) == 1) {
				isAvailable = false;
			}
		}
		Utility.closeStatement(validateExistanceQuery);
		Utility.closeConnection(connection);
		return isAvailable;
	}

}
