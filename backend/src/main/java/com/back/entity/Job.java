package com.back.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="jobdetail")
public class Job {
	@Id
	private int jobid;
	private String jobtitle;
	@Lob//large character object
	private String jobDesc;
	private String skills;
	private String yrsOfExp;
	private String salary;
	private String companyname;
	private String location;
	private Date postedOn;
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobDescription() {
		return jobDesc;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDesc = jobDescription;
	}
	public String getSkillsrequired() {
		return skills;
	}
	public void setSkillsrequired(String skillsrequired) {
		this.skills = skillsrequired;
	}
	public String getYrsOfExp() {
		return yrsOfExp;
	}
	public void setYrsOfExp(String yrsOfExp) {
		this.yrsOfExp = yrsOfExp;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}	
	

}
