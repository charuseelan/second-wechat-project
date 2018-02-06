package com.back.dao;

import java.util.List;


import com.back.entity.Blogpost;
import com.back.entity.blogcomment;


public interface blogpostdao {
	void saveBlogPost(Blogpost blogPost);

	List<Blogpost> getBlogPosts(int approved);

	Blogpost getBlogPostById(int id);
	void updateBlogPost(Blogpost blogpost);
	void addBlogComment(blogcomment blogComment);
	List<blogcomment> getAllBlogComments(int blogPostId);

}
