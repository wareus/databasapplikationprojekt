angular.module("ArnProjectPlanner", ["ngRoute", "test"]).config(function($routeProvider) {
    $routeProvider
	    .when("/", {
	    	templateUrl : "html/views/Bashemsida.html",
	    	controller  : "testController"
	    })
	    .when("/test", {
	    	templateUrl : "html/views/test.html",
	    	controller  : "testController"
	    })
});