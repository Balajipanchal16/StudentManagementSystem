package com.dov;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bo.AddStudentsIndb;
import com.bo.StudentManagementSystem;

public class DatabaseCon {

	public static Connection getConnections()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","Balaji@212816");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	public static int insertData(StudentManagementSystem std)
	{
		
		int status=0;
		 
		try
		{
			Connection con=DatabaseCon.getConnections();
			String sql="insert into student(name,email,user,password) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, std.getName());
			ps.setString(2, std.getEmail());
			ps.setString(3, std.getUser());
			ps.setString(4, std.getPassword());
			 status=ps.executeUpdate();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
	public static boolean login(String user,String password)
	{
		boolean status=false;
		 
		try
		{
			Connection con=DatabaseCon.getConnections();
			String sql="select * from student where user=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status =rs.next();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	public static int AddStudents(AddStudentsIndb as)
	{
		int status=0;
		 
		try
		{
			Connection con=DatabaseCon.getConnections();
			String  sql="insert into studentrecord(name,email,phone,stream,clgname,dob,city,state,counntry,zip) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, as.getName());
			ps.setString(2, as.getEmail());
			ps.setString(3, as.getPhone());
			ps.setString(4, as.getStream());
			ps.setString(5, as.getClgname());
			ps.setString(6, as.getDob());
			ps.setString(7, as.getCity());
			ps.setString(8, as.getState());
			ps.setString(9, as.getCountry());
			ps.setInt(10, as.getZip());
			status= ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static List getDetailsStd()
	{
		List<AddStudentsIndb> students=new ArrayList<AddStudentsIndb>();
		try
		{
			Connection con=DatabaseCon.getConnections();
			String sql="select * from studentrecord";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AddStudentsIndb st=new AddStudentsIndb();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setPhone(rs.getString(4));
				st.setStream(rs.getString(5));
				st.setClgname(rs.getString(6));
				st.setDob(rs.getString(7));
				st.setCity(rs.getString(8));
				st.setState(rs.getString(9));
				st.setCountry(rs.getString(10));
				st.setZip(rs.getInt(11));
				students.add(st);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}
	public static AddStudentsIndb GetStudentsDetailsById(int id)
	{
		AddStudentsIndb  ob=new AddStudentsIndb();
		try
		{
			Connection con=DatabaseCon.getConnections();
			String sql="select * from studentrecord where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setEmail(rs.getString(3));
				ob.setPhone(rs.getString(4));
				ob.setStream(rs.getString(5));
				ob.setClgname(rs.getString(6));
				ob.setDob(rs.getString(7));
				ob.setCity(rs.getString(8));
				ob.setState(rs.getString(9));
				ob.setCountry(rs.getString(10));
				ob.setZip(rs.getInt(11));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
	public static int updateDetailsByID(AddStudentsIndb ob)
	{
		int status=0;
		try
		{
			Connection con=DatabaseCon.getConnections();
			String sql="update studentrecord set name=?,email=?,phone=?,stream=?,clgname=?,dob=?,city=?,state=?,counntry=?,zip=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getEmail());
			ps.setString(3, ob.getPhone());
			ps.setString(4, ob.getStream());
			ps.setString(5, ob.getClgname());
			ps.setString(6, ob.getDob());
			ps.setString(7, ob.getCity());
			ps.setString(8, ob.getState());
			ps.setString(9, ob.getCountry());
			ps.setInt(10, ob.getZip());
			ps.setInt(11, ob.getId());
			status=ps.executeUpdate();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int deleteStudentData(int id)
	{
		int status=0;
		try
		{
			Connection con=DatabaseCon.getConnections();
			String sql="delete from studentrecord where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			status=ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int isPresentEmail(String email)
	{
		
		int userId = 0;
		try
		{
			 Connection	con=DatabaseCon.getConnections();
			 String sql="select * from student where email=?";
			 PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				if(	rs.next())
					userId=rs.getInt("id");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}
	public static int setPassword(StudentManagementSystem ob)
	{
//		StudentManagementSystem ob=new StudentManagementSystem();
		int status=0;
		try
		{
			Connection	con=DatabaseCon.getConnections();
			String sql="update student set password=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ob.getPassword());
			ps.setInt(2, ob.getId());
			status=ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
