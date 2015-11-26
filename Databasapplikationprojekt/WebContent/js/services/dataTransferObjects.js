angular.module('dto', ['api'])

.service('User', function(API) {
	
	return API('api/user');
	
})
.service('Project', function(API) {
	
	var api = API('api/project');
	
	api.othersProjects = function( callback)
	{
		API('api/project/othersProjects').query(callback);
	}
	
	api.yourProjects = function(callback)
	{
		API('api/project/yourProjects').query(callback);
	}
	
	return api;
})
.service('UserWorksOn', function(API) {
	
	
	var api = API('api/usersWorksOn');
	
	api.connectProjectToMe = function(projectID)
	{
		UserWorksOn = API('api/usersWorksOn/connectProjectToMe');
		new UserWorksOn({projectID:projectID}).$save();
	}
	
	return api;
	
}) 
.service('Event', function(API) {
	
	return API('api/event');
});
