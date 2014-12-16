package com.ionixx.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ionixx.UserPojo;

@Repository("DataDAO")
public class DataDAOImpl implements DataDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addData(UserPojo user) {
		sessionFactory.getCurrentSession().save(user);
		
	}

	@SuppressWarnings("unchecked")
	public List<UserPojo> listData() {
		return sessionFactory.getCurrentSession().createQuery("From UserPojo").list();
	}

	public UserPojo editUser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserPojo> list = session.createQuery("from UserPojo u where u.id = :id").setParameter("id", id).list();
		return list.size() > 0 ?(UserPojo)list.get(0): null;
	}

	public void updateData(UserPojo user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);;		
	}

	public void deleteData(Integer id) {
		UserPojo book = (UserPojo)sessionFactory.getCurrentSession()
				.load(UserPojo.class, id);
			if(null != book) {
				sessionFactory.getCurrentSession().delete(book);
			}
		
	}

}
