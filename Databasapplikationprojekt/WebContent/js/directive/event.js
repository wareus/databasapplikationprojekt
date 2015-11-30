angular.module('eventDirective', [ 'event' ]).directive('event', function(Event) {

	
	

	return {
		restrict : 'E',

		templateUrl : 'html/directive/event.html',

		controller : [ '$scope', function($scope) {
			$scope.eventClick = function()
			{
				
				
				Event.save($scope.event).$promise.catch(function(response) {
				    if(response.status == 401) alert("Something went wrong", "Try again!");
				}
				);
				console.log($scope);
				
				
			}
		} ]
	}

});
