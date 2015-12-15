angular.module('login', ['ngResource'])
.service('Login', function($resource) {
	
		var api = $resource("api/login/:id")
	
		api.logout = function()
		{
			$resource("api/login/logout").query(function()
			{
				if(update != null)
					update();
			});
		}
		
		return api;



});
