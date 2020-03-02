package com.manage.meeting.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.meeting.mapper.DeptMapper;
import com.manage.meeting.pojo.Dept;
import com.manage.meeting.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired DeptMapper deptMapper;
	
	@Override
	public List<Dept> list(Map<String, String> paramMap) {
		return deptMapper.list(paramMap);
	}

	@Override
	public void add(Dept dept) {
		deptMapper.add(dept);
	}

	@Override
	public void delete(int id) {
		deptMapper.delete(id);
	}

	@Override
	public void update(Dept dept) {
		deptMapper.update(dept);
	}

	@Override
	public Dept get(int id) {
		return deptMapper.get(id);
	}

	@Override
	public List<Dept> allDepts() {
		return deptMapper.allDepts();
	}

}
