package tech.utils;

import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletResponse;

interface utilsInterface {
		public String getEventUrl(HttpServletResponse request, HttpServletResponse response) throws Exception;
		public HttpURLConnection oauthConnection(String eventUrl) throws Exception;
		public String readJson(HttpURLConnection req) throws Exception;
}
