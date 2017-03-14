package ravi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import ravi.model.ResponseSuccess;

/**
 * Servlet implementation class CreateSub
 */
@WebServlet("/CreateSub")
public class CreateSub extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String eventUrl = (String) request.getParameter("eventUrl");
		ObjectMapper mapper = new ObjectMapper();
		response.setStatus(200);
		ResponseSuccess responseObject = new ResponseSuccess(true, "new-account-identifier");
		String json = mapper.writeValueAsString(responseObject);
		out.print(json);
		System.out.println(eventUrl);
	}

}
