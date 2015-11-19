angular.module('calendarDirective', ['ui.calendar'])
.directive('calendar', function() {
	
	console.log(21);
	
	
	return {
		restrict : 'E',
		templateUrl : 'html/directive/calendar.html',
		
		controller : [ '$scope', function($scope) {
				
			
					console.log(22);
					
					$scope.eventSources = [];
					
					$scope.uiConfig = {
						      calendar:{
						        height: 450,
						        editable: true,
						        header:{
						          left: 'month basicWeek ',
						          center: 'title',
						          right: 'today prev,next'
						        },
						        dayClick: $scope.alertEventOnClick,
						        eventDrop: $scope.alertOnDrop,
						        eventResize: $scope.alertOnResize
						      }
						    };
					console.log(12);
					
					
					
				}
			]
	}

});