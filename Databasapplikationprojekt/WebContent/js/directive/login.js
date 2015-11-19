angular.module('loginDirective', [ 'login' ])
.directive('login', function() {
	
	
	
	return {
		restrict : 'E',
		
		templateUrl : 'html/directive/login.html'

	}

});