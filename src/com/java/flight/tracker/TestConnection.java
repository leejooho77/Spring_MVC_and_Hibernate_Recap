package com.java.flight.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.Base64;
import java.util.Properties;

/**
 * Servlet implementation class TestConnection
 */
@WebServlet("/TestConnection")
public class TestConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// get database configuration from properties file
		Properties properties = new Properties();
		InputStream config = getServletContext().getResourceAsStream("/WEB-INF/application.properties");
		properties.load(config);
		// decode username, password, and url using Base64.Decoder
		byte[] decodedUsername = Base64.getDecoder().decode(properties.getProperty("jdbc.username"));
		byte[] decodedPassword = Base64.getDecoder().decode(properties.getProperty("jdbc.password"));
		// setup connection variable
		String username = new String(decodedUsername, "utf-8");
		String password = new String(decodedPassword, "utf-8");
		String url = properties.getProperty("jdbc.url");
		String driver = properties.getProperty("jdbc.driver");
		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + url);
			Class.forName(driver);
			// connect to database
			Connection connection = DriverManager.getConnection(url, username, password);
			out.println("Connected to database successfully!");
			// close connection
			connection.close();
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
