package com.manage.meeting.pojo;

import java.util.List;

public class User {
	private int id;
	private String name;
	private String realname;
	private String password;
	private String number;
	private String email;
	private String job;
	private int deptId;
	private String deptName;
	private List<Role> roles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public User(int id, String name, String realname, String password, String number, String email, String job,
			int deptId, String deptName, List<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.realname = realname;
		this.password = password;
		this.number = number;
		this.email = email;
		this.job = job;
		this.deptId = deptId;
		this.deptName = deptName;
		this.roles = roles;
	}
	public User() {
		super();
	}
}
