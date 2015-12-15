angular.module('eventDirective', [ 'dto' ]).directive('event', function(Event,$filter) {

	
	

	return {
		restrict : 'E',

		templateUrl : 'html/directive/event.html',

		controller : [ '$scope', function($scope,calendar) {
			$scope.eventClick = function()
			{
				
				
				
				var event = $scope.event;
				event.startDate = {
						date:{
							year:$filter('date')($scope.event.startDate,'yyyy'),
							month:$filter('date')($scope.event.startDate,'M'),
							day:$filter('date')($scope.event.startDate,'d')
						}
				
				},
				event.endDate = {
						date:{
							year:$filter('date')($scope.event.endDate,'yyyy'),
							month:$filter('date')($scope.event.endDate,'M'),
							day:$filter('date')($scope.event.endDate,'d')
						}
				
				};
				
				Event.addForYou(new Event(event));
			
			
				
					
				var eventSaved = $scope.$parent.$parent.cancel;
					
				if(eventSaved !== undefined)
					eventSaved();
					
				
			}
		} ]
	}

});
