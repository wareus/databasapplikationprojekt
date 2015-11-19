
angular.module("ArnProjectPlanner", ["ngRoute", "test", "errorHandler","calendarDirective", "loginDirective", "loginModalButtonDirective"]).config(function($routeProvider) {
    $routeProvider
	    .when("/", {
	    	templateUrl : "html/views/Bashemsida.html",
	    	controller  : "testController"
	    })
	    .when("/test", {
	    	templateUrl : "html/views/test.html",
	    	controller  : "testController"
	    })
	     .when("/calendar", {
	    	templateUrl : "html/views/calendar.html",
	    	controller  : "testController"
	    })
});
