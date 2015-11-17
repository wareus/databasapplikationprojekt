angular.module("ArnProjectPlanner", ["ngRoute", "test", "errorHandler", "loginDirective"]).config(function($routeProvider) {
    $routeProvider
	    .when("/", {
	    	templateUrl : "html/views/test.html",
	    	controller  : "testController"
	    })
});