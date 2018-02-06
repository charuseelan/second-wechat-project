package com.back.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.back.entity.Profilepic;

@Repository
@Transactional
public class ProfilepicDAOimpl implements ProfilepicDAO {
	@Autowired
	private SessionFactory sessionfactory;
	
	public void save(Profilepic profilePicture){
		Session session=sessionfactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
	}
	
	public Profilepic getProfilePicture(String username){
		Session session=sessionfactory.getCurrentSession();
		Profilepic profilePicture=(Profilepic)session.get(Profilepic.class,username);
		return profilePicture;
	}
	
}
