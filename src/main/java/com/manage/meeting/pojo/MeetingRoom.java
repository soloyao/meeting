package com.manage.meeting.pojo;

public class MeetingRoom {
	private int id;
	private String address;
	private String name;
	private int count;
	private String machine;
	private String remark;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public MeetingRoom(int id, String address, String name, int count, String machine, String remark, int status) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.count = count;
		this.machine = machine;
		this.remark = remark;
		this.status = status;
	}
	public MeetingRoom() {
		super();
	}
}
