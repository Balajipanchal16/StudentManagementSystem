package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.AddStudentsIndb;
import com.dov.DatabaseCon;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public StudentUpdateServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		AddStudentsIndb eb=DatabaseCon.GetStudentsDetailsById(id);
		pw.print("<form  action='updatecontroller' method='post'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td> </td><td><input type='hidden'  name='id' value='"+eb.getId()+"' /></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>Stream : </td> <td><input type='text' name='stream' value='"+eb.getStream()+"'/></td></tr>");
	   	pw.print("<tr><td>College Name: </td> <td><input type='text' name='clgname' value='"+eb.getClgname()+"'/></td></tr>");
	   	pw.print("<tr><td>DOB : </td> <td><input type='text' name='dob' value='"+eb.getDob()+"'/></td></tr>");
		pw.print("<tr><td>City:</td> <td><input type='text' name='city' value='"+eb.getCity()+"'/></td></tr>");
	   	pw.print("<tr><td>State : </td> <td><input type='text' name='state' value='"+eb.getState()+"'/></td></tr>");
	   	pw.print("<tr><td>Country: </td> <td><input type='text' name='country' value='"+eb.getCountry()+"'/></td></tr>");
	   	pw.print("<tr><td>Zip: </td> <td><input type='number' name='zip' value='"+eb.getZip()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
	}

}
