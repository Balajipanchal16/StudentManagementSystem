package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.AddStudentsIndb;
import com.dov.DatabaseCon;

/**
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updatecontroller() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
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
		AddStudentsIndb	ob=new AddStudentsIndb(id, name, email, phone, stream, clgname, dob, city, state, country, zip);
		int status=DatabaseCon.updateDetailsByID(ob);
		if(status>0)
		{
			pw.print("<script>alert('your data has been successfully updated')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("GetStudentData");
			rd.include(request, response);
		}
		else
		{
			pw.print("<script>alert('Something went wrong')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("GetStudentData");
			rd.include(request, response);
		}
	}
}
