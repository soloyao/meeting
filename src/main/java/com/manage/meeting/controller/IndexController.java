package com.manage.meeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login/login");
		return mav;
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("login/register");
		return mav;
	}
	
	@GetMapping("/demo")
	public ModelAndView demo() {
		ModelAndView mav = new ModelAndView("demo");
		return mav;
	}
	
	@GetMapping("/demo2")
	public ModelAndView demo2() {
		ModelAndView mav = new ModelAndView("demo2");
		return mav;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home/home");
		return mav;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index/index");
		return mav;
	}
	
	@GetMapping("/listUser")
	public ModelAndView listUser() {
		ModelAndView mav = new ModelAndView("user/listUser");
		return mav;
	}
	
	@GetMapping("/listRole")
	public ModelAndView listRole() {
		ModelAndView mav = new ModelAndView("role/listRole");
		return mav;
	}
	
	@GetMapping("/listPermission")
	public ModelAndView listPermission() {
		ModelAndView mav = new ModelAndView("permission/listPermission");
		return mav;
	}
	
	@GetMapping("/listMeetingRoomManage")
	public ModelAndView listMeetingRoomManage() {
		ModelAndView mav = new ModelAndView("meetingRoom/listMeetingRoomManage");
		return mav;
	}
	
	@GetMapping("/listMeetingRoom")
	public ModelAndView listMeetingRoom() {
		ModelAndView mav = new ModelAndView("meetingRoom/listMeetingRoom");
		return mav;
	}
	
	@GetMapping("/listCheck")
	public ModelAndView listCheck() {
		ModelAndView mav = new ModelAndView("meetingRoom/listCheck");
		return mav;
	}
	
	@GetMapping("/listMyApply")
	public ModelAndView listMyApply() {
		ModelAndView mav = new ModelAndView("meetingRoom/listMyApply");
		return mav;
	}
	
	@GetMapping("/listMeeting")
	public ModelAndView listMeeting() {
		ModelAndView mav = new ModelAndView("meetingRoom/listMeeting");
		return mav;
	}
	
	@GetMapping("/listMeetingCount")
	public ModelAndView listMeetingCount() {
		ModelAndView mav = new ModelAndView("meetingRoom/listMeetingCount");
		return mav;
	}
	
	@GetMapping("/listReservation")
	public ModelAndView listReservation() {
		ModelAndView mav = new ModelAndView("meetingRoom/listReservation");
		return mav;
	}
	
	@GetMapping("/listReservationManage")
	public ModelAndView listReservationManage() {
		ModelAndView mav = new ModelAndView("meetingRoom/listReservationManage");
		return mav;
	}
	
	@GetMapping("/listDeptManage")
	public ModelAndView listDept() {
		ModelAndView mav = new ModelAndView("dept/listDept");
		return mav;
	}
}
