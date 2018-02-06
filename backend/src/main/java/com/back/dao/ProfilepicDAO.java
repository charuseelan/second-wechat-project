package com.back.dao;

import com.back.entity.Profilepic;
public interface ProfilepicDAO {

void save(Profilepic profilePicture);
Profilepic getProfilePicture(String username);

}
