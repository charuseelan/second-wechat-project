var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/home',{
		templateUrl:'views/home.html'
	})
	.when('/register',{
		templateUrl:'views/register.html',
		controller:'UserController'
	})
	.when('/login',{
		templateUrl:'views/login.html',
		controller:'UserController'
	})
	.when('/updateuser',{
		templateUrl:'views/updateuserprofile.html',
		controller:'UserController'
	})
	.when('/getAllUsers',{
		templateUrl:'views/listofusers.html'
	})
	.when('/saveblogpost',{
		templateUrl:'views/blogpostform.html',
		controller:'BlogPostController'
	})
	.when('/getallblogs',{
		templateUrl:'views/listofblogposts.html',
		controller:'BlogPostController'
	})
	.when('/getblogpostbyid/:id',{
		templateUrl:'views/blogpostdetails.html',
		controller:'BlogPostDetailController'
	})
	.when('/approveblogpost/:id',{
		templateUrl:'views/blogpostapprovalform.html',
		controller:'BlogPostDetailController'
	})
	.when('/suggesteduserslist',{
		templateUrl:'views/listofsuggestedusers.html',
		controller:'FriendController'
	})
	.when('/pendingfriendrequests',{
		templateUrl:'views/listofpendingrequests.html',
		controller:'FriendController'
	})
	.when('/getUserDetails/:fromId',{
		templateUrl:'views/userdetails.html',
		controller:'FriendDetailController'
	})
	.when('/profilepic',{
		templateUrl:'views/ProfilePicture.html'
	})

	
	.when('/friendsList',
	{
		templateUrl:'views/ListofFriends.html',
		controller:'FriendController'
	})
	.when('/savejob',{
		templateUrl:'views/jobform.html',
		controller:'JobController'
	})
	.when('/getalljobs',{
		templateUrl:'views/jobtitles.html',
		controller:'JobController'
	})
	.when('/chat',{
		templateUrl:'views/chat.html',
		controller:'chatController'
	})

})
app.run(function($rootScope,$cookieStore,UserService,$location){
	if($rootScope.currentUser==undefined)
		$rootScope.currentUser=$cookieStore.get("currentUser")
		
		$rootScope.logout=function(){
        UserService.logout().then(function(response){
        	$rootScope.logoutSuccess="Loggedout Successfully.."
        		delete $rootScope.currentUser
        		$cookieStore.remove("currentUser")
        		$location.path('/login');
        },function(response){
        	$location.path('/login')
        })		
	}		
})