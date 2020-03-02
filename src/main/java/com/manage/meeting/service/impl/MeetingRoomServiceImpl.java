package com.manage.meeting.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.manage.meeting.mapper.MeetingRoomMapper;
import com.manage.meeting.pojo.MeetingRoom;
import com.manage.meeting.service.MeetingRoomService;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
	@Autowired MeetingRoomMapper meetingRoomMapper;
	
	@Override
	public List<MeetingRoom> list(Map<String, String> paramMap) {
		List<MeetingRoom> list = meetingRoomMapper.list(paramMap);
		List<MeetingRoom> result = new ArrayList<MeetingRoom>();
		for (MeetingRoom meetingRoom : list) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("currentTime", new Date().toLocaleString());
			map.put("meetingRoomId", String.valueOf(meetingRoom.getId()));
			int exist = meetingRoomMapper.exist(map);
			if (exist == 0) {
				meetingRoom.setStatus(0);
			} else {
				meetingRoom.setStatus(1);
			}
			result.add(meetingRoom);
		}
		return result;
	}

	@Override
	public void add(MeetingRoom meetingRoom) {
		meetingRoomMapper.add(meetingRoom);
	}

	@Override
	public void delete(int id) {
		meetingRoomMapper.delete(id);
	}

	@Override
	public void update(MeetingRoom meetingRoom) {
		meetingRoomMapper.update(meetingRoom);
	}

	@Override
	public MeetingRoom get(int id) {
		return meetingRoomMapper.get(id);
	}

}
