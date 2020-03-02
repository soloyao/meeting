package com.manage.meeting.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.meeting.pojo.Dept;

@Mapper
public interface DeptMapper {
	List<Dept> allDepts();
	List<Dept> list(Map<String, String> paramMap);
	void add(Dept dept);
	void delete(int id);
	void update(Dept dept);
	Dept get(int id);
}
