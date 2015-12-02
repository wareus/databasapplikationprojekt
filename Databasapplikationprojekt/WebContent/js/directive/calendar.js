angular.module('calendarDirective', [ 'ui.calendar']).directive('calendar',
		function() {
			return {
				restrict : 'E',
				templateUrl : 'html/directive/calendar.html',

				controller : [ '$scope', function($scope,$resource) {
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
//					$scope.events = {
//					      //  url : $scope.rootPath + "event/events.json",
//							//url : Events.yourEvents(User.id),
//					        type : 'GET',
//					        data: {  
////					           user_id: User.id,
//					           //token: $scope.user.token
//					        },
//					        success: function(data) {
//					
//					            for (var i = 0; i < data.events.length; i++) {
//					                //Konvertering
//					                var t = data.events[i].start.split(/[- :]/);
//					                data.events[i].start = new Date(t[0], t[1]-1, t[2], t[3], t[4], t[5]);
//					                var t = data.events[i].end.split(/[- :]/);
//					                data.events[i].end = new Date(t[0], t[1]-1, t[2], t[3], t[4], t[5]);
//					            };
//					            return data.events;
//					        }
//					    }; 
//					    $scope.eventSources = [$scope.events];

				} ]
			}

		});