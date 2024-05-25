package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dov.DatabaseCon;

/**
 * Servlet implementation class DeleteStudentInfo
 */
@WebServlet("/DeleteStudentInfo")
public class DeleteStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		int status=DatabaseCon.deleteStudentData(id);
		if(status>0)
		{
			pw.print("<script>alert('data has been succeesfully deleted')</script>");
		}
		else
		{
			pw.print("<script>alert('Something went wrong')</script>");
		}
		pw.print("<a href='dashboard.html' >dashborad</a>");
	}

}
