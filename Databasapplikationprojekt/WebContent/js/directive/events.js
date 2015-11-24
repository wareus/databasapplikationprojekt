angular.module('eventsDirective', [ 'events' ]).directive('events', function(Events) {


	
	

	return {
		restrict : 'E',

		templateUrl : 'html/directive/events.html',

		controller : [ '$scope', function($scope) {
			$scope.loginClick = function()
			{
				Login.save($scope.login).$promise.catch(function(response) {
				    if(response.status == 401) alert("Something went wrong", "Try again!");
				});
				
				
				
			}
		} ]
	}

});
