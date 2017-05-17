package com.epam.simpleweb04.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
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
	
	private static Connection con;
	private static volatile ConnectionPool pool;
	private static BasicDataSource ds;
	
	private ConnectionPool(){
		/*ds = new BasicDataSource();
		ds.setDriverClassName(resource.getString(DB_DRIVER_CLASS));
		ds.setUsername(resource.getString(DB_USERNAME));
		ds.setPassword(resource.getString(DB_PASSWORD));
		ds.setUrl(resource.getString(DB_URL));
		
		ds.setMinIdle(3);
		ds.setMaxIdle(5);
		ds.setMaxOpenPreparedStatements(10);
		ds.setMaxActive(5);
		ds.setMaxWait(10000);*/
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
		/*try {
			return ds.getConnection();
		} catch (SQLException e) {
			LOGGER.fatal("Unable to get the Connection",e);
			throw new RuntimeException("Unable to get the Connection",e);
		}*/
		URI jdbUri;
		  try {
		   jdbUri = new URI(
		     "mysql://jj1krafoo3uhdqj0:xqslvd943eiyrtd4@gzp0u91edhmxszwf.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/gg4hyz6gpvflvqpc");
		   String username = jdbUri.getUserInfo().split(":")[0];
		   String password = jdbUri.getUserInfo().split(":")[1];
		   String port = String.valueOf(jdbUri.getPort());
		   String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();
		   Class.forName(resource.getString(DB_DRIVER_CLASS));
		   con = DriverManager.getConnection(jdbUrl, username, password);
		  } catch (URISyntaxException e) {
			  e.printStackTrace();
		  } catch (SQLException e) {
			  e.printStackTrace();
		  } catch (ClassNotFoundException e) {
			  e.printStackTrace();
		  }

		  return con;
		
	}
}
