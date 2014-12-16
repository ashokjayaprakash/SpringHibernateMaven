package com.ionixx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ionixx.UserPojo;
import com.ionixx.dao.DataDAO;

@Service("DataService")
public class DataServiceImpl implements DataService{

	@Autowired
	DataDAO d;
	
	@Transactional
	public void addData(UserPojo user) {
		d.addData(user);		
	}
	@Transactional
	public List<UserPojo> listData() {		
		return d.listData();
	}
	@Transactional
	public UserPojo editUser(Integer id) {
		// TODO Auto-generated method stub
		return d.editUser(id);
	}
	@Transactional
	public void updateData(UserPojo user) {
		d.updateData(user);		
	}
	@Transactional
	public void deleteData(Integer id) {
		d.deleteData(id);
	}
	

}
