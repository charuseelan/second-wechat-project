app.factory('MydetailService',function($http){
	var mydetailService={}
	var friendService={}
	friendService.getMyDetails=function(fromId){
		  return  $http.get("http://localhost:8085/backend/getmydetails/"+fromId)
		}
	return mydetailService;
})
