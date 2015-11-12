angular.module('dto', ['api'])

.service('User', function(API) {
	
	return API('api/user');
	
});