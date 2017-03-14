package Servlets_Practice;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import java.sql.*;
class DBConnection 
{
	public static Connection getConnection() throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample", "root", "password");
        
        
        return con;
    }
}
