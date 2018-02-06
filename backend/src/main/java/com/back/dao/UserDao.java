package com.back.dao;

import java.util.List;

import com.back.entity.User;



public interface UserDao {
	public void adduser(User user);
	public List<User> getList();
	public void deleteuser(User user);
	public User getUser(String username);
	public void updateUser(User user);
	public User login(User user);
	User getUserByUsername(String username);
	public User validateUsername(String username);
	public User validateEmailId(String emailId);
	
}
