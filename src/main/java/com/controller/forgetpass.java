package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dov.DatabaseCon;

/**
 * Servlet implementation class forgetpass
 */
@WebServlet("/forgetpass")
public class forgetpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public forgetpass() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("user");
		int userId=DatabaseCon.isPresentEmail(email);
		if(userId > 0)
		{
			pw.print("<script>alert('Email is present ! Now you can reset password ')</script>");
			pw.print("<link rel='stylesheet' type='text/css' href='./CSS/styles1.css'>");
			pw.print("<div class='mainpages'>");
			pw.print("<div class='maincont'>");
			pw.print("<form action='SetPassword' method='post'>");
			pw.print("<h1 style='color:navy'>Set New Password</h1>");
			pw.print("<input type='hidden' name='userId' value='"+userId+"'>");
			pw.print("<input type='text' name='user' value='"+email+"'>");
			pw.print("<input type=\"password\" name=\"password\" placeholder=\"Enter your password\">");
			pw.print(" <button type=\"submit\" id='btn'>Submit</button>");
			pw.print("</form>");
			pw.print("</div>");
			pw.print("</div>");
		}
		else
		{
			pw.print("<script>alert('Username does not exist') </script>");
			RequestDispatcher rq=request.getRequestDispatcher("ForgetPassword.html");
			rq.include(request, response);
		}
		
	}
}
