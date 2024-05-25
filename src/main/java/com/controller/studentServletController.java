package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.StudentManagementSystem;
import com.dov.DatabaseCon;

/**
 * Servlet implementation class studentServletController
 */
@WebServlet("/studentServletController")
public class studentServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public studentServletController() {
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		StudentManagementSystem std=new StudentManagementSystem(name,email,user,password);
		int status=DatabaseCon.insertData(std);
		if(status>0)
		{
			pw.print("your data has been successfully inserted");
		}
		else
		{
			pw.print("something went wrong try again******");
		}
	}

}
