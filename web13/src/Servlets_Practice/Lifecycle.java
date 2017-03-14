package Servlets_Practice;
import java.io.*;
import javax.servlet.*;

public class Lifecycle extends GenericServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		System.out.print("Inside Init Method");
	}
	
	public void service(ServletRequest arg0,ServletResponse arg1) throws ServletException,IOException
	{
		System.out.println("Inside Service Method");
	}	
	public void destroy()
	{
		System.out.println("Inside destroy method");
	}
}

