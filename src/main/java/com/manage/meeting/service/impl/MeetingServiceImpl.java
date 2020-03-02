package com.manage.meeting.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.meeting.mapper.MeetingMapper;
import com.manage.meeting.mapper.MeetingRoomMapper;
import com.manage.meeting.pojo.Meeting;
import com.manage.meeting.pojo.MeetingUser;
import com.manage.meeting.pojo.User;
import com.manage.meeting.service.MeetingService;

@Service
public class MeetingServiceImpl implements MeetingService {
	@Autowired MeetingMapper meetingMapper;
	@Autowired MeetingRoomMapper meetingRoomMapper;
	
	@Override
	public void meetingApply(Meeting meeting) {
		meetingMapper.meetingApply(meeting);
		String users = meeting.getUsers();
		String[] usersArr = users.split(",");
		for (String userId : usersArr) {
			MeetingUser meetingUser = new MeetingUser();
			meetingUser.setMeetingId(meeting.getId());
			meetingUser.setUserId(Integer.parseInt(userId));
			meetingMapper.meetingUserAdd(meetingUser);
		}
	}
	
	@Override
	public void meetingReservation(Meeting meeting) {
		meetingMapper.meetingReservation(meeting);
		String users = meeting.getUsers();
		String[] usersArr = users.split(",");
		for (String userId : usersArr) {
			MeetingUser meetingUser = new MeetingUser();
			meetingUser.setMeetingId(meeting.getId());
			meetingUser.setUserId(Integer.parseInt(userId));
			meetingMapper.meetingUserAdd(meetingUser);
		}
	}
	
	@Override
	public List<Meeting> list(Map<String, String> paramMap) {
		List<Meeting> list = meetingMapper.list(paramMap);
		for (Meeting meeting : list) {
			List<User> users = meetingMapper.listMeetingUsers(meeting);
			for (User user : users) {
				meeting.setUsers(user.getName() + (meeting.getUsers().equals("")?"":("," + meeting.getUsers())));
			}
		}
		return list;
	}
	
	@Override
	public List<Meeting> meetingsCheck(Map<String, String> paramMap) {
		List<Meeting> list = meetingMapper.meetingsCheck(paramMap);
		for (Meeting meeting : list) {
			List<User> users = meetingMapper.listMeetingUsers(meeting);
			for (User user : users) {
				meeting.setUsers(user.getName() + (meeting.getUsers().equals("")?"":("," + meeting.getUsers())));
			}
		}
		return list;
	}
	
	@Override
	public List<Meeting> meetingsReservation(Map<String, String> paramMap) {
		List<Meeting> list = meetingMapper.meetingsReservation(paramMap);
		for (Meeting meeting : list) {
			List<User> users = meetingMapper.listMeetingUsers(meeting);
			for (User user : users) {
				meeting.setUsers(user.getName() + (meeting.getUsers().equals("")?"":("," + meeting.getUsers())));
			}
		}
		return list;
	}
	
	@Override
	public List<Meeting> meetingCounts(Map<String, String> paramMap) {
		List<Meeting> list = meetingRoomMapper.meetingCounts(paramMap);
		for (Meeting meeting : list) {
			List<User> users = meetingMapper.listMeetingUsers(meeting);
			for (User user : users) {
				meeting.setUsers(user.getName() + (meeting.getUsers().equals("")?"":("," + meeting.getUsers())));
			}
		}
		return list;
	}
	
	@Override
	public List<Meeting> listMyMeetings(Map<String, String> paramMap) {
		List<Meeting> list = meetingMapper.listMyMeetings(paramMap);
		for (Meeting meeting : list) {
			List<User> users = meetingMapper.listMeetingUsers(meeting);
			for (User user : users) {
				meeting.setUsers(user.getName() + (meeting.getUsers().equals("")?"":("," + meeting.getUsers())));
			}
		}
		return list;
	}

	@Override
	public void meetingPass(Meeting meeting) {
		meetingMapper.meetingPass(meeting);
		meetingMapper.useMeetingRoom(meeting);
	}

	@Override
	public void meetingRefuse(Meeting meeting) {
		meetingMapper.meetingRefuse(meeting);
	}

	@Override
	public void useMeetingRoom(Meeting meeting) {
		meetingMapper.useMeetingRoom(meeting);
	}

	@Override
	public void freeMeetingRoom(Meeting meeting) {
		meetingMapper.freeMeetingRoom(meeting);
	}

	@Override
	public void cancelReservation(int id) {
		meetingMapper.cancelReservation(id);
		MeetingUser meetingUser = new MeetingUser();
		meetingUser.setMeetingId(id);
		meetingMapper.deleteUserByMeeting(meetingUser);
	}

}
