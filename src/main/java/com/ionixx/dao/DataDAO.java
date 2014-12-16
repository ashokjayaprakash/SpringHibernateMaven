package com.ionixx.dao;

import java.util.List;

import com.ionixx.UserPojo;

public interface DataDAO {
	public void addData(UserPojo user);
	public List<UserPojo> listData();
	public UserPojo editUser(Integer id);
	public void deleteData(Integer id);
	public void updateData(UserPojo user);
}
