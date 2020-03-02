package com.manage.meeting.service;

import java.util.List;
import java.util.Map;

import com.manage.meeting.pojo.MeetingRoom;

public interface MeetingRoomService {
	List<MeetingRoom> list(Map<String, String> paramMap);
	void add(MeetingRoom meetingRoom);
	void delete(int id);
	void update(MeetingRoom meetingRoom);
	MeetingRoom get(int id);
}
