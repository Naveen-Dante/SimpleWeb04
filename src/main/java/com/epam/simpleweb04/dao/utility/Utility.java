package com.epam.simpleweb04.dao.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Utility {

	private static final Logger LOGGER = Logger.getLogger(Utility.class);

	public static void closeScanner(Scanner scanner) {
		scanner.close();
	}

	public static void closeStatement(PreparedStatement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			LOGGER.error("Unable to close connection. ", e);
		}
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
