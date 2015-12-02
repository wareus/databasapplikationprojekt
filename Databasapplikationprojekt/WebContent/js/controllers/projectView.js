angular.module('projectView', ['dto','login'])
.controller("testController", function($scope, User, Login){
	
	$scope.update = function()
	{
		$scope.projectList.update();
		console.log("sune");
	}
	
});
