/**
 * 
 */
app.factory('FriendService',function($http){
	var friendService={}
	
	friendService.listOfSuggestedUsers=function(){
	  return  $http.get("http://localhost:8085/backend/getsuggestedusers")
	}
	friendService.friendRequest=function(toId){
		  return  $http.post("http://localhost:8085/backend/friendRequest/"+toId)
		}
	
	friendService.listOfPendingRequests=function(toId){
		  return  $http.get("http://localhost:8085/backend/getpendingrequests")
		}
	friendService.getUserDetails=function(fromId){
		  return  $http.get("http://localhost:8085/backend/getuserdetails/"+fromId)
		}
	
	friendService.updatePendingRequest=function(pendingRequest){
		  return  $http.put("http://localhost:8085/backend/updatependingrequest",pendingRequest)
		}
	friendService.listOfFriends=function(){
		return $http.get("http://localhost:8085/backend/friendslist")
	}
	
	return friendService;
})
