package uk.ac.dundee.computing.yek.controller;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBconnection {
	protected final String Username = "YolinaKostova";
	protected final String Password = "ac31004";
	protected final String connectionSTR = "jdbc:mysql://arlia.computing.dundee.ac.uk/YolinaKostova";
	
	protected Connection con;
	
	public DBconnection() {
		try {
			con = (Connection) DriverManager.getConnection(connectionSTR,Username,Password);
		} catch (Exception e) {
			con = null;
		}
	}
	
	public static Connection getConnectionInstance() {
		return (new DBconnection()).getConnection();
	}
	
	public Connection getConnection(){
		return con;
	}
}
