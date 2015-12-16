angular.module('projectView', ['dto','login'])
.controller("testController", function($scope, User, Login){
	
	console.log($scope);
	
	update = function()
	{
		$scope.projectList.update();
		
	}
	
});
