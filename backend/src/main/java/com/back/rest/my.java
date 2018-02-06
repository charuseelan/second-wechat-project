package com.back.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.back.dao.UserDao;
import com.back.entity.Error;
import com.back.entity.User;


public class my {
	@Autowired
	UserDao userdao;
	@RequestMapping(value="/getmydetails/{fromId}",method=RequestMethod.GET)
	public ResponseEntity<?> getUserDetails(@PathVariable String fromId,HttpSession session){
		if(session.getAttribute("username")==null){
			Error err=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(err,HttpStatus.UNAUTHORIZED);
		}
		User user=userdao.getUserByUsername(fromId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
