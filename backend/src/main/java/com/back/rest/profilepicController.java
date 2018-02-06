package com.back.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.back.dao.ProfilepicDAO;
import com.back.entity.Error;
import com.back.entity.Profilepic;
@RestController
public class profilepicController {
	@Autowired
	ProfilepicDAO profilePictureDao;
		@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public ResponseEntity<?> uploadProfilePic(@RequestParam CommonsMultipartFile image,HttpSession session){
			System.out.println(session.getAttribute("username"));
		
		if(session.getAttribute("username")==null){
			Error err=new Error(5,"UnAuthroized User");
			return new ResponseEntity<Error>(err,HttpStatus.UNAUTHORIZED);
		}
		String username=(String)session.getAttribute("username");
		Profilepic profilePicture=new Profilepic();
		profilePicture.setUsername(username);
		profilePicture.setImage(image.getBytes());
		try{
		profilePictureDao.save(profilePicture);
		return new ResponseEntity<Profilepic>(profilePicture,HttpStatus.OK);
		}catch(Exception e){
			Error err=new Error(6,"Unable to upload");
			return new ResponseEntity<Error>(err,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
		
		@RequestMapping(value="/getimage/{username}", method=RequestMethod.GET)
		public @ResponseBody byte[] getImage(@PathVariable String username,HttpSession session)
		{
		
			if(session.getAttribute("username")==null){
				return null;
		}
		else
		{
			Profilepic profilePicture=profilePictureDao.getProfilePicture(username);
			if(profilePicture==null)
				return null;
			
			System.out.println(profilePicture.getImage());
			return profilePicture.getImage();
	}
	}


}
