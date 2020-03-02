package com.manage.meeting.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.meeting.pojo.Meeting;
import com.manage.meeting.pojo.MeetingUser;
import com.manage.meeting.pojo.User;

@Mapper
public interface MeetingMapper {
	void meetingApply(Meeting meeting);
	void meetingReservation(Meeting meeting);
	List<Meeting> list(Map<String, String> paramMap);
	List<Meeting> meetingsCheck(Map<String, String> paramMap);
	List<Meeting> meetingsReservation(Map<String, String> paramMap);
	List<Meeting> listMyMeetings(Map<String, String> paramMap);
	void meetingUserAdd(MeetingUser meetingUser);
	List<User> listMeetingUsers(Meeting meeting);
	List<Meeting> currentMeetings(Map<String, String> paramMap);
	void meetingPass(Meeting meeting);
	void meetingRefuse(Meeting meeting);
	void useMeetingRoom(Meeting meeting);
	void freeMeetingRoom(Meeting meeting);
	void cancelReservation(int id);
	void deleteUserByMeeting(MeetingUser meetingUser);
}
