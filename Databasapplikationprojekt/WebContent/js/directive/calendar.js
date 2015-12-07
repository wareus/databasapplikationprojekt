angular
		.module('calendarDirective', [ 'ui.calendar', 'dto' ])
		.directive(
				'calendar',
				function(Event) {
					return {
						restrict : 'E',
						templateUrl : 'html/directive/calendar.html',

						controller : [
								'$scope',
								function($scope, $resource) {
									$scope.events = [];
									$scope.eventSources = new Array();

									$scope.test = function() {

										var event = $scope.event;
										Event
												.forYou(function(data) {

													for (i = 0; i < data.length - 1; i++) {
														$scope.events
																.push({
																	title : data[i].title,
																	start : new Date(
																			data[i].startDate.date.year,
																			data[i].startDate.date.month - 1,
																			data[i].startDate.date.day),
																	end : new Date(
																			data[i].endDate.date.year,
																			data[i].endDate.date.month - 1,
																			data[i].endDate.date.day)
																});
													}
												})

									};
									$scope.uiConfig = {

										calendar : {

											height : 500,
											weekNumbers : true,
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
											eventResize : $scope.alertOnResize,

										}
									};
									$scope.eventSources = [$scope.events];
									

								} ]
					}

				});