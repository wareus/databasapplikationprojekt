angular.module('projectView', ['dto','login'])
.controller("testController", function($scope, User, Login){
	
	update = function()
	{
		$scope.projectList.update();
		
	}
	
});
