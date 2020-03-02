package com.manage.meeting.service;

import java.util.List;
import java.util.Map;

import com.manage.meeting.pojo.Dept;

public interface DeptService {
	List<Dept> allDepts();
	List<Dept> list(Map<String, String> paramMap);
	void add(Dept dept);
	void delete(int id);
	void update(Dept dept);
	Dept get(int id);
}
