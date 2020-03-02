package com.manage.meeting.pojo;

public class MeetingUser {
	private int id;
	private int meetingId;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public MeetingUser(int id, int meetingId, int userId) {
		super();
		this.id = id;
		this.meetingId = meetingId;
		this.userId = userId;
	}
	public MeetingUser() {
		super();
		// TODO Auto-generated constructor stub
	}
}
