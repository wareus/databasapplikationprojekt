angular.module('eventFetcherDirective', ['dto']).directive('eventFetcher', function(User) {

	return {
		restrict : 'E',

		controller : [ '$scope', function($scope) {
			
			
			Event.yourEvents(function(id) {
				$scope.User.id = id;
			});
			
		} ]
	}

});