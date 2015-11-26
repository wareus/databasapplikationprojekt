angular.module('projectHandlerDirective', ['dto']).directive('projectHandler', function(Project, UserWorksOn) {

	return {
		restrict : 'E',

		templateUrl : 'html/directive/projectHandler.html',

		controller : [ '$scope', function($scope) {
			$scope.projectHandler = {
				create : function()
				{
					new Project({name:$scope.projectHandler.projectName}).$save();
					//TODO new UserWorksOn
				}
			}
			
			Project.othersProjects(function(data) {
				$scope.projectHandler.projectList = data;
			});
			
		} ]
	}

});