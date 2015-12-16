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
																	id: data[i].id,
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
																id: data[i].id,
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
									$scope.update();
											
									$scope.remove = function() {
										console.log("Jens");
									}	

												
									$scope.uiConfig = {

										calendar : {
											
											editable: true,
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
											eventClick : $scope.alertEventOnClick,
											eventDrop : $scope.alertOnDrop,
											eventRender: function(event, element) { 
											    element.find('.fc-time').hide();
											},
											eventDrop: function(event) {
												//ta sedan bort ifrån databasen
												console.log(event.start._d),
												console.log(event.end._d)
												Event.updateEvent(function(data) {
													
													
												});
											},
											eventClick: function(event) {
												
												
												
												$scope.calendar.fullCalendar('removeEvents' ,[ event.id]);
												Event.removeEvent(function(data) {
													
												});
											}
											
										}
									};
								
								
							   
									
								} ]
					}

				});
