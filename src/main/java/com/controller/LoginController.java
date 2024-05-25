package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dov.DatabaseCon;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
       
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		boolean status=DatabaseCon.login(user, password);
		if(status)
		{
			pw.print("<script>alert('login sucessfully!!')</script>");
			RequestDispatcher rs=request.getRequestDispatcher("dashboard.html");
			rs.include(request, response);
		}
		else
		{
			RequestDispatcher rs=request.getRequestDispatcher("login.html");
			rs.include(request, response);
			pw.print("<script>alert('Something went wrong!!')</script> ");
		}
	}
}
