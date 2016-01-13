

angular.module("ArnProjectPlanner", ["ngRoute", "test", "errorHandler","calendarDirective", "loginDirective", "loginModalButtonDirective", "eventModalButtonDirective", "eventDirective", "720kb.datepicker","projectView","calendarView", "projectListDirective", "projectHandlerDirective", "mainController"]).config(function($routeProvider) {
    $routeProvider
	    .when("/", {
	    	templateUrl : "html/views/homepage.html",
	    	controller  : "testController"
	    })
	    .when("/test", {
	    	templateUrl : "html/views/test.html",
	    	controller  : "testController"
	    })
	     .when("/calendar", {
	    	templateUrl : "html/views/calendar.html",
	    	controller  : "calendarController"
	    })
	    .when("/projectView", {
	    	templateUrl : "html/views/projectView.html",
	    	controller  : "testController"
	    })
});
