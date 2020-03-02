package com.manage.meeting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.meeting.pojo.MeetingRoom;
import com.manage.meeting.service.MeetingRoomService;

@RestController
public class MeetingRoomController {
	@Autowired MeetingRoomService meetingRoomService;
	
	@GetMapping("/meetingRooms")
	public PageInfo<MeetingRoom> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size);
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<MeetingRoom> ms = meetingRoomService.list(paramMap);
		PageInfo<MeetingRoom> page = new PageInfo<MeetingRoom>(ms, 5);
		return page;
	}
	
	@GetMapping("/meetingRooms/{id}")
	public MeetingRoom get(@PathVariable("id") int id) {
		MeetingRoom meetingRoom = meetingRoomService.get(id);
		return meetingRoom;
	}
	
	@PostMapping("/meetingRooms")
	public String add(@RequestBody MeetingRoom meetingRoom) {
		meetingRoomService.add(meetingRoom);
		return "success";
	}
	
	@PutMapping("/meetingRooms")
	public String update(@RequestBody MeetingRoom meetingRoom) {
		meetingRoomService.update(meetingRoom);
		return "success";
	}
	
	@DeleteMapping("/meetingRooms/{id}")
	public String delete(@PathVariable("id") int id) {
		meetingRoomService.delete(id);
		return "success";
	}
}
