package com.manage.meeting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.manage.meeting.pojo.Meeting;
import com.manage.meeting.pojo.User;
import com.manage.meeting.service.MeetingService;

@RestController
public class MeetingController {
	@Autowired MeetingService meetingService;
	
	@PostMapping("/meetingApply")
	public String meetingApply(@RequestBody Meeting meeting, HttpSession session) {
		User currentUser = (User) session.getAttribute("user");
		String userStr = currentUser.getName();
		meeting.setUser(userStr);
		meetingService.meetingApply(meeting);
		return "success";
	}
	
	@PostMapping("/meetingReservation")
	public String meetingReservation(@RequestBody Meeting meeting, HttpSession session) {
		User currentUser = (User) session.getAttribute("user");
		String userStr = currentUser.getName();
		meeting.setUser(userStr);
		meetingService.meetingReservation(meeting);
		return "success";
	}
	
	@GetMapping("/myMeetings")
	public PageInfo<Meeting> myMeetings(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword,
			HttpSession session) {
		PageHelper.startPage(start, size);
		Map<String, String> paramMap = new HashMap<String, String>();
		User currentUser = (User) session.getAttribute("user");
		String user = currentUser.getName();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		paramMap.put("user", user);
		List<Meeting> ms = meetingService.listMyMeetings(paramMap);
		PageInfo<Meeting> page = new PageInfo<Meeting>(ms, 5);
		return page;
	}
	
	@GetMapping("/meetingCounts")
	public PageInfo<Meeting> meetingCounts(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "date", defaultValue = "") String date) {
		PageHelper.startPage(start, size);
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(date)) {
			paramMap.put("startTime", date + " 00:00:00");
			paramMap.put("endTime", date + " 23:59:59");
		}
		List<Meeting> ms = meetingService.meetingCounts(paramMap);
		PageInfo<Meeting> page = new PageInfo<Meeting>(ms, 5);
		return page;
	}
	
	@GetMapping("/meetings")
	public PageInfo<Meeting> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size);
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<Meeting> ms = meetingService.list(paramMap);
		PageInfo<Meeting> page = new PageInfo<Meeting>(ms, 5);
		return page;
	}
	
	@DeleteMapping("/cancelReservation/{id}")
	public String cancelReservation(@PathVariable("id") int id) {
		meetingService.cancelReservation(id);
		return "success";
	}
	
	@GetMapping("/meetingsReservation")
	public PageInfo<Meeting> meetingsReservation(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size);
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<Meeting> ms = meetingService.meetingsReservation(paramMap);
		PageInfo<Meeting> page = new PageInfo<Meeting>(ms, 5);
		return page;
	}
	
	@GetMapping("/meetingsCheck")
	public PageInfo<Meeting> meetingsCheck(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size);
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<Meeting> ms = meetingService.meetingsCheck(paramMap);
		PageInfo<Meeting> page = new PageInfo<Meeting>(ms, 5);
		return page;
	}
	
	@PutMapping("/meetingPass")
	public String meetingPass(@RequestBody Meeting meeting) {
		meetingService.meetingPass(meeting);
		return "success";
	}
	
	@PutMapping("/meetingRefuse")
	public String meetingRefuse(@RequestBody Meeting meeting) {
		meetingService.meetingRefuse(meeting);
		return "success";
	}
}
