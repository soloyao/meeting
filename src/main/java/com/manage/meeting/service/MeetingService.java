package com.manage.meeting.service;

import java.util.List;
import java.util.Map;

import com.manage.meeting.pojo.Meeting;

public interface MeetingService {
	void meetingApply(Meeting meeting);
	void meetingReservation(Meeting meeting);
	List<Meeting> list(Map<String, String> paramMap);
	List<Meeting> meetingsCheck(Map<String, String> paramMap);
	List<Meeting> meetingsReservation(Map<String, String> paramMap);
	List<Meeting> meetingCounts(Map<String, String> paramMap);
	List<Meeting> listMyMeetings(Map<String, String> paramMap);
	void meetingPass(Meeting meeting);
	void meetingRefuse(Meeting meeting);
	void useMeetingRoom(Meeting meeting);
	void freeMeetingRoom(Meeting meeting);
	void cancelReservation(int id);
}
