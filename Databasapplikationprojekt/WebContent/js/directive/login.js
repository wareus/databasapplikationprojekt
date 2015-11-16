angular.module('loginDirective', [ 'login' ])
.directive('login', function() {
	
	console.log(123);
	
	return {
		restrict : 'E',
		templateUrl : 'html/directive/login.html'

	}

});