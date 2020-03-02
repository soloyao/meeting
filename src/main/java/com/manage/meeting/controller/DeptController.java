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
import com.manage.meeting.pojo.Dept;
import com.manage.meeting.service.DeptService;

@RestController
public class DeptController {
	@Autowired DeptService deptService;
	
	@GetMapping("/allDepts")
	public List<Dept> allDepts() {
		return deptService.allDepts();
	}
	
	@GetMapping("/depts")
	public PageInfo<Dept> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size);
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<Dept> ds = deptService.list(paramMap);
		PageInfo<Dept> page = new PageInfo<Dept>(ds, 5);
		return page;
	}
	
	@GetMapping("/depts/{id}")
	public Dept get(@PathVariable("id") int id) {
		Dept dept = deptService.get(id);
		return dept;
	}
	
	@PostMapping("/depts")
	public String add(@RequestBody Dept dept) {
		deptService.add(dept);
		return "success";
	}
	
	@PutMapping("/depts")
	public String update(@RequestBody Dept dept) {
		deptService.update(dept);
		return "success";
	}
	
	@DeleteMapping("/depts/{id}")
	public String delete(@PathVariable("id") int id) {
		deptService.delete(id);
		return "success";
	}
}
