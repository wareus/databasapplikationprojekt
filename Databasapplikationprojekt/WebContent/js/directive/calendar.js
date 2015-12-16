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
								function($scope, uiCalendarConfig) {
										$scope.events = [];
										$scope.eventSources = [];
										
										
										
										$scope.update = function() {
											
											Event
											.forYou(function(data) {
												$scope.calendar.fullCalendar('removeEventSource', $scope.events);
												$scope.events = [];
												
												for (i = 0; i < data.length; i++) {
													
													if(data[i].startDate != null && data[i].endDate != null) {
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
																			data[i].endDate.date.day),
																	color: 'yellow',   // an option!
																	textColor: 'black',
																	stick : true
																});
														} else if(data[i].startDate != null && data[i].endDate == null) {
															$scope.events
															.push({
																title : data[i].title,
																start : new Date(
																		data[i].startDate.date.year,
																		data[i].startDate.date.month - 1,
																		data[i].startDate.date.day),
																color: 'yellow',   // an option!
																textColor: 'black',
																stick : true
															});
															
														}
													
												}
												$scope.calendar.fullCalendar('addEventSource', $scope.events);
												
												
											});
											
										};
										Event
										.forYou(function(data) {
											
											
											for (i = 0; i < data.length; i++) {
										
												if(data[i].startDate != null && data[i].endDate != null) {
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
																	data[i].endDate.date.day),
															color: 'yellow',   // an option!
															textColor: 'black',
															stick : true
														});
												} else if(data[i].startDate != null && data[i].endDate == null) {
													$scope.events
													.push({
														title : data[i].title,
														start : new Date(
																data[i].startDate.date.year,
																data[i].startDate.date.month - 1,
																data[i].startDate.date.day),
														color: 'yellow',   // an option!
														textColor: 'black',
														stick : true
													});
													
												}
											
											}
											$scope.calendar.fullCalendar('addEventSource', $scope.events);
										});
									
									
											
										

												
									$scope.uiConfig = {

										calendar : {

											height : 500,
											weekNumbers : true,
											stick : true,
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
											eventRender: function(event, element) { 
											    element.find('.fc-time').hide();
											}
											
										}
									};
									
									
								
							   
									
								} ]
					}

				});
