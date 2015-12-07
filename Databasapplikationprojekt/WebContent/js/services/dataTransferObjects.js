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
	
	api.select = function(id)
	{
		API('api/project/select/' +id).save();
	}
	
	return api;
})
.service('UserWorksOn', function(API) {
	
	
	var api = API('api/userWorksOn');
	
	api.connectProjectToMe = function(projectID)
	{
		UserWorksOn = API('api/userWorksOn/connectProjectToMe');
		new UserWorksOn({projectID:projectID}).$save();
	}
	
	return api;
	
}) 
.service('Event', function(API) {
	
var api = API('api/event');
	
	api.forYou = function(callback)
	{
		API('api/event/forYou').query(callback);
	}
	
	
	return api;
	
});
