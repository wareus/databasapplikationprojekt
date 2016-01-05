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
	
	api.connectProjectToMe = function(projectID, callback)
	{
		UserWorksOn = API('api/userWorksOn/connectProjectToMe');
		new UserWorksOn({projectID:projectID}).$save(callback);
	}
	
	return api;
	
}) 
.service('Event', function(API) {
	
var api = API('api/event');
	
	api.forYou = function(callback)
	{
		API('api/event/forYou').query(callback);
	}
	api.forCategory = function(category,callback)
	{
		API('api/event/forCategory/' +category).query(callback);
	}
	api.addForYou = function(event, callback)
	{
		var api = API('api/event/addForYou');
		new api(event).$save(callback);
	}
	api.updateEvent = function(event,callback)
	{
		
		var api = API('api/event/updateEvent');
		new api(event).$save(callback); 
		
	}
	api.removeEvent = function(id)
	{
		API('api/event/removeEvent/' +id).remove();
	}
	
	
	return api;
	
});
