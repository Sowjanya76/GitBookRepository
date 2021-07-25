package com.mindtree.bookdistribution.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.bookdistribution.exception.UtilityException;

public class DbConnector {
	static Connection connection=null;
	private static String dbName="studentDb";
	private static final String url="jdbc:mysql://localhost:3306/"+dbName;
	
	private static final String userName="root";
	private static final String password="16JN1A0508";
	public static Connection connectionToDatabase() throws UtilityException  
	{
		Connection connection=null;
				try{
					connection=DriverManager.getConnection(url,userName,password);
				}
				catch(SQLException e)
				{
						throw new UtilityException("connection not available");
				}
		
		return connection;
		}
}
