package com.back.dao;

import java.util.List;

import com.back.entity.Friend;
import com.back.entity.User;


public interface FriendDAO {

List<User> getListOfSuggestedUsers(String username);
void addFriendRequest(String username,String toId);
List<Friend> getPendingRequests(String username);
void updatePendingRequest(Friend pendingRequest);
List<Friend> listOfFriends(String username);
}
