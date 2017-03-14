package tech.dao;
import java.sql.*;

public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, Exception
    {
        //Loading JDBC Driver
        Class.forName("com.mysql.jdbc.Driver");

        //Creating Connection with Database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TechChallenge" , "root","password");
        //System.out.println("Database connection established");
        return con;
    }

}
