angular.module('calendarView', ['dto'])
.controller("calendarController", function($scope){
	
	update = function()
	{
		
		console.log("hehj");
		console.log($scope);
		$scope.calendar.update();
		
	}
});
