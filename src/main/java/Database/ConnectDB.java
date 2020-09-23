package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Helpers.LoggerHelper;

public class ConnectDB {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		ConnectDB c = new ConnectDB();
		String username= c.createcon()[0].toString();
		LoggerHelper.log("Username coming is: "+ username);
	}
	
	
	public static Object[] createcon() throws SQLException {
		String name = null;
		int id = 0;
		String host ="localhost";
		String port ="3306";
		String databasename="appium";
		Connection con= DriverManager.getConnection("jdbc:mysql://"+ host+":"+ port+ "/"+databasename,"root","root");
		LoggerHelper.log("Database connection Object: "+ con);
		Statement s= con.createStatement();
		LoggerHelper.log("Database statement Object: "+ s);
		ResultSet rs= s.executeQuery("select * from Employeeinfo where name='sam';");
		LoggerHelper.log("Database ResultSet Object: "+ rs);
		//got exception Exception in thread "main" java.sql.SQLException: Before start of result set if 
		//while (rs.next()) { not used because it points to the base index 
		//by default its in the 0th value i.e. first index
		//move your pointer from base to first index
		while (rs.next()) {
			name= rs.getString("name");
			LoggerHelper.log("Username coming is: "+ name);
			id= rs.getInt("age");
			LoggerHelper.log("Age coming is: "+ id);
		}
		return new Object[] {name,id};
		
		 
		
		
//		Connection URL format
//		"jdbc:mysql://"+ host+":"+ port+ "/databasename";
		
//		jdbc: working with mysql DB 
//		mysql: Databas i am using 
//	    host: What machine in our case its local machine so localhost
//	    port: while installing default port number is 3306 on which the DB is listening 
//      databasename: name of DB you want to connect
	}

}
