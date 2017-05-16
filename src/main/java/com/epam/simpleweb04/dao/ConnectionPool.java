package com.epam.simpleweb04.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

public class ConnectionPool {

	private static final String BASENAME = "Config";
	private static final String DB_DRIVER_CLASS = "DB_DRIVER_CLASS";
	private static final String DB_URL = "DB_URL";
	private static final String DB_USERNAME = "DB_USERNAME";
	private static final String DB_PASSWORD = "DB_PASSWORD";
	private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
	private static final ResourceBundle resource = ResourceBundle.getBundle(BASENAME, Locale.US);
	
	private static volatile ConnectionPool pool;
	private static BasicDataSource ds;
	
	private ConnectionPool(){
		ds = new BasicDataSource();
		ds.setDriverClassName(resource.getString(DB_DRIVER_CLASS));
		ds.setUsername(resource.getString(DB_USERNAME));
		ds.setPassword(resource.getString(DB_PASSWORD));
		ds.setUrl(resource.getString(DB_URL));
		
		ds.setMinIdle(5);
		ds.setMaxIdle(30);
		ds.setMaxOpenPreparedStatements(200);
		ds.setMaxWait(10000);
	}
	
	public static ConnectionPool getPool(){
		if(pool == null){
			synchronized (ConnectionPool.class) {
				if(pool == null)
					pool = new ConnectionPool();
			}
		}
		return pool;
	}
	
	public Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			LOGGER.fatal("Unable to get the Connection",e);
			throw new RuntimeException("Unable to get the Connection",e);
		}
		
	}
}
