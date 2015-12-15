angular.module('mainController', ['login'])
.controller("mainController", function($scope,Login){
	
	$scope.logout = function()
	{
		Login.logout();
		
		
		if($scope.$$childHead.update != undefined)
		{
			$scope.$$childHead.update();
			
		}
	}
	
});