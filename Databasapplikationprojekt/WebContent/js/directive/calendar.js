angular.module('calendarDirective', [ 'ui.calendar' ]).directive('calendar',function() {
	return {
			restrict : 'E',
			templateUrl : 'html/directive/calendar.html',

			controller : ['$scope',
					function($scope) {
								$scope.eventSources = [{
									events: [	{		
									         title: 'Doktorsavhandling',
									         url: 'http://google.com/',
									         start: '2015-11-28'
										},	{
											title: 'Long Event',
											start: '2015-11-07',
											end: '2015-11-10',
											color: 'yellow',   // an option!
								            textColor: 'black'
										},
										{
											title: 'All Day Event',
											start: '2015-11-01'
										}]	
								}];
								
								
								
								$scope.uiConfig = {
										
									calendar : {
										
										height : 500,
										editable : true,
										weekNumbers: true,
										header : {
											
											left : 'month basicWeek basicQuarter',
											center : 'title',
											right : 'today prev,next'
										},
										selectable: true,
										selectHelper: true,
										select: function(start, end) {
											var title = prompt('Event Title:');
											var eventData;
											if (title) {
												eventData = {
													title: title,
													start: start,
													end: end,
												}
												$scope.eventSources = [{
													events: [	{		
												         title: 'Hejsan',												        
												         start: '2015-11-16',
												         end: '2015-11-22'
													}]
												}];
												
											}
											console.log(eventData);
											
										},
										
										views : {												
											basicQuarter : {
											type : 'basic',
											duration : {
											months : 3
											},
											buttonText : 'quarter'
											}
											},
											dayClick : $scope.alertEventOnClick,
											eventDrop : $scope.alertOnDrop,
											eventResize : $scope.alertOnResize,
											
										}
									};

								} ]
					}

				});