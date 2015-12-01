angular.module('loginDirective', [ 'login' ]).directive('login', function(Login) {

	
	

	return {
		restrict : 'E',

		templateUrl : 'html/directive/login.html',

		controller : [ '$scope', function($scope) {
			$scope.loginClick = function()
			{
				Login.save($scope.login, function(data) {
					
				}).$promise.catch(function(response) {
					
					
				});
				

				
				
			}
		} ]
	}

});
