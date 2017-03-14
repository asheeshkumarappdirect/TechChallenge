package Servlets_Practice;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Login extends HttpServlet
{
	static PreparedStatement pst =null;
	private String pwd,uid;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Installed");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","root","password");
			pst = con.prepareStatement("select name,password from Users where name=? AND password=?");		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		PrintWriter pw = res.getWriter();
		uid = req.getParameter("uid");
		pwd = req.getParameter("pwd");
		
		System.out.println("GETTING Uid="+uid+"\tPword="+pwd);
		try
		{
			pst.setString(1,uid);
			pst.setString(2,pwd);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				pw.println("---");
				RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
				rd.forward(req,res);
			}
			else
			{
				res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				out.println("<p style=color:red;font-size:18px>INVALID</p>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");			
				rd.include(req, res);	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String toString()
	{
		return "UID= "+uid+"Password: "+pwd;
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		doGet(req,res);
	}
}
