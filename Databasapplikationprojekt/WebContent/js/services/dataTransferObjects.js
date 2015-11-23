angular.module('dto', ['api'])

.service('User', function(API) {
	
	return API('api/user');
	
})
.service('Project', function(API) {
	
	return API('api/project');
})
.service('UserWorksOn', function(API) {
	
	return API('api/usersWorksOn');
	
}) 
.service('Event', function(API) {
	
	return API('api/event');
});
