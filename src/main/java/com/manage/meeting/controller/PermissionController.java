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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.meeting.pojo.Permission;
import com.manage.meeting.pojo.User;
import com.manage.meeting.service.PermissionService;

@RestController
public class PermissionController {
	@Autowired PermissionService permissionService;
	JSONObject json = new JSONObject();
	
	@GetMapping("/permissionsByUser")
	public JSONArray getPermissionsByUser(HttpSession session) {
		User user = (User) session.getAttribute("user");
		return permissionService.listByUser(user);
	}
	
	@GetMapping("/parentPermissions")
	public List<Permission> list() {
		return permissionService.listParentPermissions();
	}
	
	@GetMapping("/permissions")
	public PageInfo<Permission> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword,
			@RequestParam(value = "pid") String pid) {
		PageHelper.startPage(start, size);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("pid", pid);
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<Permission> rs = permissionService.list(paramMap);
		PageInfo<Permission> page = new PageInfo<Permission>(rs, 5);
		return page;
	}
	
	@GetMapping("/permissions/{id}")
	public Permission get(@PathVariable("id") int id) {
		Permission permission = permissionService.get(id);
		return permission;
	}
	
	@PostMapping("/permissions")
	public String add(@RequestBody Permission permission) {
		int exist = permissionService.exist(permission);
		if (0 != exist) {
			json.put("code", 1);
			json.put("msg", "菜单名已存在");
		} else {
			permissionService.add(permission);
			json.put("code", 0);
			json.put("msg", "新增成功");
		}
		return json.toJSONString();
	}
	
	@PutMapping("/permissions")
	public String update(@RequestBody Permission permission) {
		permissionService.update(permission);
		return "success";
	}
	
	@DeleteMapping("/permissions/{id}")
	public String delete(@PathVariable("id") int id) {
		permissionService.delete(id);
		return "success";
	}
}
