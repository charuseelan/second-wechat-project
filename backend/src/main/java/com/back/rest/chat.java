package com.back.rest;

import java.util.Date;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.back.entity.outputmessage;


@RestController
public class chat {
	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public outputmessage sendMessage(com.back.entity.Message message){
		return new outputmessage(message,new Date());
	}

}
