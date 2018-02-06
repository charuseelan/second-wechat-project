package com.back.dao;

import java.util.List;

import com.back.entity.Job;



public interface JobDAO {
	void saveJob(Job job);

	List<Job> getAllJobs();

	Job getJobById(int id);

}
