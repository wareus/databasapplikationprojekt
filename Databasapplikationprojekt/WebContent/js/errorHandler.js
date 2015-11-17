angular.module('errorHandler', []).config(["$httpProvider", function ($httpProvider) {

	$httpProvider.interceptors.push(function($q) {

			
		console.log("^^");
			var success = function(response) {
	            return response;
	        }
	        var error = function(response) {
	            var status = response.status;
	            console.log("=)");
	            if (status == 401) {
	            	
	            	console.log(401);
	            	
	                return;
	            }
	            return $q.reject(response);
	        }
	        return function (promise) {
	            return promise.then(success, error);

		};
	});
	
    }]);
