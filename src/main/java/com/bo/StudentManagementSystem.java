package com.bo;

public class StudentManagementSystem {
	
	public StudentManagementSystem(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	private int id;
	private String name;
	private String email;
	private String user;
	private String password;
	public StudentManagementSystem(String name, String email, String user, String password) {
//		super();
		this.name = name;
		this.email = email;
		this.user = user;
		this.password = password;
	}
	
	public StudentManagementSystem(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public StudentManagementSystem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
