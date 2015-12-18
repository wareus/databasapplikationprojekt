angular
		.module('calendarDirective', [ 'ui.calendar', 'dto' ])
		.directive(
				'calendar',
				function(Event,$filter) {
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
												
												if(event.end != null && event.start != null)
													{
													var start = {
															date:{
																year:$filter('date')(event.start._d,'yyyy'),
																month:$filter('date')(event.start._d,'M'),
																day:$filter('date')(event.start._d,'d')
															}
				
													};
													var end = {
															date:{
																year:$filter('date')(event.end._d,'yyyy'),
																month:$filter('date')(event.end._d,'M'),
																day:$filter('date')(event.end._d,'d')
															}
				
														}
													} 
												else  {
													var start = {
															date:{
																year:$filter('date')(event.start._d,'yyyy'),
																month:$filter('date')(event.start._d,'M'),
																day:$filter('date')(event.start._d,'d')
															}
						
														}
													var end = null;
													}
												
												var newEvent = {id:event.id, title:event.title,startDate:start, endDate:end};
												
												Event.updateEvent(new Event(newEvent), function()
												{
													
													update();
													
												});
											},
											eventClick: function(event) {
												
												var id = event.id;
												
												$scope.calendar.fullCalendar('removeEvents' ,[ id]);
												Event.removeEvent(id, function()
												{
													update();
													
												});
											}
											
										}
									};
								
								
							   
									
								} ]
					}

				});
