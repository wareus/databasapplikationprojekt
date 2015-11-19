angular.module('loginDirective', [ 'login' ]).directive('login', function(Login) {


	
	

	return {
		restrict : 'E',

		templateUrl : 'html/directive/login.html',

		controller : [ '$scope', function($scope) {
			$scope.loginClick = function()
			{
				Login.save($scope.login).$promise.catch(function(response) {
				    if(response.status == 401) alert("please retry to login agin", "Login failed");
				});
				
				
				
			}
		} ]
	}

});
