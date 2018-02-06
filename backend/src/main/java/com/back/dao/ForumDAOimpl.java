package com.back.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.back.entity.Forum;
@Repository
@Transactional
public class ForumDAOimpl implements ForumDAO{
	@Autowired
	SessionFactory sessionfactory;
	public void addForum(Forum forum)
	{
		try
		{
			Session session=sessionfactory.openSession();
			Transaction trans=session.beginTransaction();
			session.save(forum);
			trans.commit();
			session.flush();
			session.close();
		}
		
		catch(Exception ex)
		{
			System.out.println("Error="+ex);
		}

	}
	public List<Forum> getList()
	{
		Session session=sessionfactory.openSession();
		Transaction trans=session.beginTransaction();
		List<Forum> showuser=session.createQuery("from Forum").list();
		trans.commit();
		session.close();
		return showuser;
		
	}
	public void deleteforum(Forum forum)
	{
		Session session=sessionfactory.openSession();
		Transaction trans=session.beginTransaction();  
		session.delete(forum);
		trans.commit();
		session.close();
	}

}
