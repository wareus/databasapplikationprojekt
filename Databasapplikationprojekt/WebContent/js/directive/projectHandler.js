angular.module('projectHandlerDirective', ['dto']).directive('projectHandler', function(Project) {

	return {
		restrict : 'E',

		templateUrl : 'html/directive/projectHandler.html',

		controller : [ '$scope', function($scope) {
			$scope.projectHandler = {
				create : function()
				{
					new Project({name:$scope.projectHandler.projectName}).$save();
				}
			}
			
			Project.query(function(data) {
				$scope.projectHandler.projectList = data;
			});
			
		} ]
	}

});