package com.manage.meeting.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.meeting.pojo.Meeting;
import com.manage.meeting.pojo.MeetingRoom;

@Mapper
public interface MeetingRoomMapper {
	List<MeetingRoom> list(Map<String, String> paramMap);
	void add(MeetingRoom meetingRoom);
	void delete(int id);
	void update(MeetingRoom meetingRoom);
	MeetingRoom get(int id);
	int exist(Map<String, String> paramMap);
	List<Meeting> meetingCounts(Map<String, String> paramMap);
}
