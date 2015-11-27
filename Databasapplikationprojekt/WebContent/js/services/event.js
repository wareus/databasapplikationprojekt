angular.module('event', ['ngResource'])
.service('Event', function($resource) {
	
		
		return $resource("api/event/:id");


});