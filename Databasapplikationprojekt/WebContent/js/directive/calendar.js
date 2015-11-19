angular
		.module('calendarDirective', [ 'ui.calendar' ])
		.directive(
				'calendar',
				function() {

					return {
						restrict : 'E',
						templateUrl : 'html/directive/calendar.html',

						controller : [
								'$scope',
								function($scope) {

									console.log(22);

									$scope.eventSources = [];

									$scope.uiConfig = {
										
										calendar : {
											height : 450,
											editable : true,
											selectable : true,
											weekNumbers: true,
											header : {
												
												left : 'month basicWeek basicQuarter',
												center : 'title',
												right : 'today prev,next'
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
											eventResize : $scope.alertOnResize
										}
									};

								} ]
					}

				});