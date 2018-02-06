package com.back.rest;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.back.dao.JobDAO;
import com.back.dao.UserDao;
import com.back.entity.Error;
import com.back.entity.Job;
import com.back.entity.User;

@RestController
public class Jobcontroller {
	@Autowired
    JobDAO jobdao;
	@Autowired
	 UserDao userdao;
	@RequestMapping(value="/savejob",method=RequestMethod.POST)
	public ResponseEntity<?> saveJob(@RequestBody Job job,HttpSession session){
		if(session.getAttribute("username")==null){
			Error err=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(err,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		User user=userdao.getUserByUsername(username);
        if(user.getRole().equals("admin")){
        	try{
        		job.setPostedOn(new Date());
        	jobdao.saveJob(job);
        	return new ResponseEntity<Job>(job,HttpStatus.OK);
        	}catch(Exception e){
        		Error err=new Error(7,"Unable to insert job details " + e.getMessage());
        		return new ResponseEntity<Error>(err,HttpStatus.INTERNAL_SERVER_ERROR);
        	}
        }
        else{
        	Error err=new Error(6,"Access Denied");
        	return new ResponseEntity<Error>(err,HttpStatus.UNAUTHORIZED);
        }
		
	}
	@RequestMapping(value="/getalljobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session){
		if(session.getAttribute("username")==null){
			Error err=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(err,HttpStatus.UNAUTHORIZED);
		}
		List<Job> jobs=jobdao.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	@RequestMapping(value="/getjobbyid/{jobid}",method=RequestMethod.GET)
	public ResponseEntity<?> getJobById(@PathVariable int jobid,HttpSession session){
		
		if(session.getAttribute("username")==null){
			Error err=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(err,HttpStatus.UNAUTHORIZED);
		}
		Job job=jobdao.getJobById(jobid);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
		
	}	


}
