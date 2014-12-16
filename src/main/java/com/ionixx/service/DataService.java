package com.ionixx.service;

import java.util.List;

import com.ionixx.UserPojo;

public interface DataService {
	
	public void addData(UserPojo user);
	public List<UserPojo> listData();
	public UserPojo editUser(Integer id); 
	public void updateData(UserPojo user);
	public void deleteData(Integer id);
}
