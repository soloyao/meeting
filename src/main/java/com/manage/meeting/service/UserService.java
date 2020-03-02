package com.manage.meeting.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.manage.meeting.pojo.User;


public interface UserService {
	User login(User user);
	void register(User user);
	int exist(User user);
	List<User> list(Map<String, String> paramMap);
	List<User> allUsers();
	List<User> freeUsers();
	void add(User user);
	void update(User user);
	void updateUser(User user);
	void delete(int id);
	User get(int id);
	void updateBatch(Set<String> userIds, Set<String> roleIds);
}
