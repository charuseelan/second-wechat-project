/**
 * 
 *//**
 * 
 */


app.factory('JobService',function($http){
	var jobService={}
	
	jobService.saveJob=function(job){
	  return  $http.post("http://localhost:8085/backend/savejob",job)
	}
	jobService.getAllJobs=function(){
		 return  $http.get("http://localhost:8085/backend/getalljobs")
	}
	jobService.getJobDetails=function(jobid){
		return $http.get("http://localhost:8085/backend/getjobbyid/"+jobid)
	}
	return jobService;
})