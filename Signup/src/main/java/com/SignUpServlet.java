package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/signup")
public class SignUpServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup_db","root","root");
			
			PreparedStatement ps=c.prepareStatement("insert into details values(?,?,?)");
			
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,pass);
			
			ps.executeUpdate();
			res.getWriter().print("<html><body><h1>Data saved successfully</h1></body></html>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
