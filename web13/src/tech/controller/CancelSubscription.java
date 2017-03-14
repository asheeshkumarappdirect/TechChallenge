package tech.controller;

import java.io.*;
import java.net.*;
import org.codehaus.jackson.map.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.codehaus.jackson.map.ObjectMapper;

import tech.models.ResponseSuccess;
import tech.services.ServicesCancelSubscription;
import tech.utils.Utilities;
import tech.beans.*;
import oauth.signpost.*;
import oauth.signpost.basic.DefaultOAuthConsumer;

@WebServlet("/CancelSubscription")
public class CancelSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   PrintWriter out = response.getWriter();
	   String eventUrl = new Utilities().getEventUrl(request,response);
	   
       ObjectMapper mapper = new ObjectMapper();
       mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       response.setStatus(200);
       ResponseSuccess responseObject = null;
       
       try{
            OAuthConsumer consumer = new DefaultOAuthConsumer("crux-154127", "HQv1THfR58EyN2rj");
            URL url = new URL(eventUrl);
            HttpURLConnection req = (HttpURLConnection) url.openConnection();
            req.setRequestProperty("Accept", "application/json");
            consumer.sign(req);
            req.connect();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
            String line = "";
            line = br.readLine();
            br.close();
                 
            TechChallenge pojo = mapper.readValue(line,TechChallenge.class);
            ServicesCancelSubscription objservicescancel = new ServicesCancelSubscription();
            
            ResponseSuccess result = objservicescancel.cancelSubscription(pojo);    
            if(result != null){
                responseObject = new ResponseSuccess(true,"random-account-identifier");
            }else{
                responseObject = new ResponseSuccess(false,"random-account-identifier");
            }  
            String json = mapper.writeValueAsString(responseObject);
            
            out.print(json);
            out.flush();
       }catch(Exception e){
           e.printStackTrace();
       }
	}
}
