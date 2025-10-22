package com.codegnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
		static final String jdbc_Url="jdbc:mysql://localhost:3306/Project";
		static final String userName="root";
		static final String password="root";
		public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection(jdbc_Url,userName,password);
			
		}
}
