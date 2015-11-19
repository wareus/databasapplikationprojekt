angular.module("ArnProjectPlanner", ["ngRoute", "test", "errorHandler", "loginDirective", "loginModalButtonDirective"]).config(function($routeProvider) {
    $routeProvider
	    .when("/", {
	    	templateUrl : "html/views/test.html",
	    	controller  : "testController"
	    })
});