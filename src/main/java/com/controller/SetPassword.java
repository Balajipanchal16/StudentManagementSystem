package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.StudentManagementSystem;
import com.dov.DatabaseCon;

/**
 * Servlet implementation class SetPassword
 */
@WebServlet("/SetPassword")
public class SetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetPassword() {
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		int userid=Integer.parseInt(request.getParameter("userId"));
		StudentManagementSystem ob=new StudentManagementSystem(userid, email, password);
		int status=DatabaseCon.setPassword(ob);
		if(status>0)
		{
			pw.print("<script>alert('Password successfully updated')</script>");
			RequestDispatcher rq=request.getRequestDispatcher("login.html");
			rq.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Something went wrong')</script>");
			RequestDispatcher rq=request.getRequestDispatcher("login.html");
			rq.include(request, response);
		}
	}
	
}
