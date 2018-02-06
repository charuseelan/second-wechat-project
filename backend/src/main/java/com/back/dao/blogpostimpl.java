package com.back.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.back.entity.Blogpost;
import com.back.entity.blogcomment;

@Repository
@Transactional
public class blogpostimpl  implements blogpostdao {
	@Autowired
	SessionFactory sessionfactory;
		public void saveBlogPost(Blogpost blogPost) {
			Session session=sessionfactory.getCurrentSession();
			session.save(blogPost);

		}
		public List<Blogpost> getBlogPosts(int approved) {
			Session session=sessionfactory.getCurrentSession();
			//if approved method parameter is 0 => select * from blogpost_batch5 where approved=0;[waiting for approval]
			//if approved parameter is 1 => select * from blogpost_batch5 where approved=1;[approved blog posts]
			Query query=session.createQuery("from Blogpost where approved="+approved);
			return query.list();
		}
		public Blogpost getBlogPostById(int id) {
			Session session=sessionfactory.getCurrentSession();
			Blogpost blogPost=(Blogpost)session.get(Blogpost.class, id);
			return blogPost;
		}
		
		public void updateBlogPost(Blogpost blogpost) {
			// TODO Auto-generated method stub
			Session session=sessionfactory.getCurrentSession();
			session.update(blogpost);
		}
		
		public void addBlogComment(blogcomment blogComment) {
			// TODO Auto-generated method stub
			Session session=sessionfactory.getCurrentSession();
			session.save(blogComment);//insert into blogComment
			}
		
		public List<blogcomment> getAllBlogComments(int blogPostId) {
			Session session=sessionfactory.getCurrentSession();
			Query query=session.createQuery("from blogcomment where Blogpost.id=?");
			query.setInteger(0, blogPostId);
			return query.list();
			
		}

	}
