angular.module("ArnProjectPlanner", ["ngRoute", "test", "loginDirective"]).config(function($routeProvider) {
    $routeProvider
	    .when("/", {
	    	templateUrl : "html/views/test.html",
	    	controller  : "testController"
	    })
});