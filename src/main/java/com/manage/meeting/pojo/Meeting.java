package com.manage.meeting.pojo;

public class Meeting {
	private int id;
	private String useMachine;
	private String startTime;
	private String endTime;
	private int meetingRoomId;
	private int important;
	private String status;
	private String resStatus;
	private String title;
	private String user;
	private String users = "";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUseMachine() {
		return useMachine;
	}
	public void setUseMachine(String useMachine) {
		this.useMachine = useMachine;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getMeetingRoomId() {
		return meetingRoomId;
	}
	public void setMeetingRoomId(int meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}
	public int getImportant() {
		return important;
	}
	public void setImportant(int important) {
		this.important = important;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResStatus() {
		return resStatus;
	}
	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public Meeting(int id, String useMachine, String startTime, String endTime, int meetingRoomId, int important,
			String status, String resStatus, String title, String user, String users) {
		super();
		this.id = id;
		this.useMachine = useMachine;
		this.startTime = startTime;
		this.endTime = endTime;
		this.meetingRoomId = meetingRoomId;
		this.important = important;
		this.status = status;
		this.resStatus = resStatus;
		this.title = title;
		this.user = user;
		this.users = users;
	}
	public Meeting() {
		super();
	}
}
