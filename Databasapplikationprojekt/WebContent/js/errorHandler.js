angular.module('errorHandler', []).config(["$httpProvider", function ($httpProvider) {

	$httpProvider.interceptors.push(function($q) {

			
		return{
			       'responseError': function(response) {
			        if(response.status === 401)
			        {
			        }
			        return $q.reject(response);
			      }

		};
	});
	
    }]);
