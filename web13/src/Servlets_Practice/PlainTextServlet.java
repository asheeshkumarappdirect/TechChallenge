package Servlets_Practice;

import java.io.*;

import javax.servlet.*;

public class PlainTextServlet extends GenericServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		
	}

	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("Welcome to world of hacking");
		out.println("<html><body bgcolor=#936 text=yellow>");
		out.println("<h1 align=center>HAT HACKER</h1>");
		out.println("<ul><li>H</li><li>R</li></ul>");
		out.println("</body></html>");
	}	
}
