package com.back.dao;

import java.util.List;

import com.back.entity.Forum;



public interface ForumDAO {
	public void addForum(Forum forum);
	public List<Forum> getList();
	public void deleteforum(Forum forum);
}
