angular.module('login', ['ngResource'])
.service('Login', function($resource) {
	
		
		return $resource("api/login/:id");


});