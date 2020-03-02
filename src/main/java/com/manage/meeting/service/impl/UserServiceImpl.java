package com.manage.meeting.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.meeting.mapper.DeptMapper;
import com.manage.meeting.mapper.MeetingMapper;
import com.manage.meeting.mapper.UserMapper;
import com.manage.meeting.pojo.Dept;
import com.manage.meeting.pojo.Meeting;
import com.manage.meeting.pojo.Role;
import com.manage.meeting.pojo.User;
import com.manage.meeting.pojo.UserRole;
import com.manage.meeting.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired UserMapper userMapper;
	@Autowired DeptMapper deptMapper;
	@Autowired MeetingMapper meetingMapper;
	
	@Override
	public User login(User user) {
		return userMapper.login(user);
	}

	@Override
	public int exist(User user) {
		return userMapper.exist(user);
	}

	@Override
	public List<User> list(Map<String, String> paramMap) {
		List<User> list = userMapper.list(paramMap);
		List<User> result = new ArrayList<User>();
		for (User user : list) {
			if (user.getDeptId() == 0) {
				user.setDeptName("");
				result.add(user);
			} else {
				Dept dept = deptMapper.get(user.getDeptId());
				user.setDeptName(dept.getName());
				result.add(user);
			}
		}
		return result;
	}

	@Override
	public void add(User user) {
		userMapper.add(user);
		if (null != user.getRoles()) {
			for (Role role : user.getRoles()) {
				UserRole userRole = new UserRole();
				userRole.setRid(role.getId());
				userRole.setUid(user.getId());
				userMapper.addRoleByUserId(userRole);
			}
		}
	}
	
	@Override
	public void register(User user) {
		userMapper.register(user);
		UserRole userRole = new UserRole();
		userRole.setRid(4);//写死（用户）
		userRole.setUid(user.getId());
		userMapper.addRoleByUserId(userRole);
	}

	
	
	@Override
	public void update(User user) {
		//删除当前用户角色
		userMapper.deleteRoleByUserId(user.getId());
		//修改用户对应角色
		if (null != user.getRoles()) {
			for (Role role : user.getRoles()) {
				UserRole userRole = new UserRole();
				userRole.setRid(role.getId());
				userRole.setUid(user.getId());
				userMapper.addRoleByUserId(userRole);
			}
		}
		//修改用户基础信息
		userMapper.update(user);
	}
	
	@Override
	public void updateBatch(Set<String> userIds, Set<String> roleIds) {
		//删除当前用户关联角色
		for (String userId : userIds) {
			userMapper.deleteRoleByUserId(Integer.parseInt(userId));
		}
		//修改用户关联角色
		if (null != roleIds) {//为空则表示去掉用户所有角色
			for (String userId : userIds) {
				for (String roleId : roleIds) {
					UserRole userRole = new UserRole();
					userRole.setRid(Integer.parseInt(roleId));
					userRole.setUid(Integer.parseInt(userId));
					userMapper.addRoleByUserId(userRole);
				}
			}
		}
	}

	@Override
	public void delete(int id) {
		userMapper.delete(id);//删除用户
		userMapper.deleteRoleByUserId(id);//同时删除用户对应的角色
	}

	@Override
	public User get(int id) {
		return userMapper.get(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.update(user);
	}

	@Override
	public List<User> freeUsers() {
		List<User> list = userMapper.freeUsers();
		Map<String, String> map = new HashMap<String, String>();
		map.put("currentTime", new Date().toLocaleString());
		List<Meeting> meetings = meetingMapper.currentMeetings(map);
		List<User> users = new ArrayList<User>();
		for (Meeting meeting : meetings) {
			List<User> meetingUsers = meetingMapper.listMeetingUsers(meeting);
			users.addAll(meetingUsers);
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < users.size(); j++) {
				if (list.get(i).getId() == users.get(j).getId()) {
					list.remove(i);
				}
			}
		}
		return list;
	}
	
	@Override
	public List<User> allUsers() {
		return userMapper.freeUsers();
	}

}
