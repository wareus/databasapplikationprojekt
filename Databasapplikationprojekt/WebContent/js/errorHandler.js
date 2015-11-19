angular.module('errorHandler', []).config(["$httpProvider", function ($httpProvider) {

	$httpProvider.interceptors.push(function($q) {

			
		console.log("hej");
		return{
			       'responseError': function(response) {
			        console.log("rejection = ");
			        console.log(response);
			        return $q.reject(response);
			      }

		};
	});
	
    }]);
