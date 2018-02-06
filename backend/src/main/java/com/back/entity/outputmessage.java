package com.back.entity;

import java.util.Date;


public class outputmessage extends Message {
	private Date time;
	
	public outputmessage(Message original, Date time)
	{
		super(original.getMessage(),original.getId());
		this.time=time;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
