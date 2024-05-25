package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.AddStudentsIndb;
import com.dov.DatabaseCon;

/**
 * Servlet implementation class AddStudents
 */
@WebServlet("/AddStudents")
public class AddStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddStudents() {
       
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String stream=request.getParameter("stream");
		String clgname=request.getParameter("clgname");
		String dob=request.getParameter("dob");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		int zip=Integer.parseInt(request.getParameter("zip"));
		
		AddStudentsIndb as=new AddStudentsIndb(name, email, phone, stream, clgname, dob, city, state, country, zip);
		
		int status=DatabaseCon.AddStudents(as);
		if(status>0)
		{
			pw.print("<script>alert('Student data successfully!')</script>");
			RequestDispatcher rs=request.getRequestDispatcher("dashboard.html");
			rs.include(request, response);
		}
		else
		{
			pw.print("<script>alert('something went wrong !!')</script>");
			RequestDispatcher rs=request.getRequestDispatcher("dashboard.html");
			rs.include(request, response);
		}
		
	}

}
