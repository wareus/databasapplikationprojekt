angular.module('projectHandlerDirective', ['dto']).directive('projectHandler', function(Project) {

	return {
		restrict : 'E',

		templateUrl : 'html/directive/projectHandler.html',

		controller : [ '$scope', function($scope) {
			$scope.projectHandler = {
				create : function()
				{
					console.log("create");
					new Project({name:"name"}).$save();
				}
			}
			
			Project.query(function(data) {
				$scope.projectHandler.projectList = data;
			});
			
		} ]
	}

});