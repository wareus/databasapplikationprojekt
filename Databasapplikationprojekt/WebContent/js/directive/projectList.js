angular.module('projectListDirective', ['dto']).directive('projectList', function(Project) {

	return {
		restrict : 'E',

		templateUrl : 'html/directive/projectList.html',

		controller : [ '$scope', function($scope) {
			
			Project.yourProjects(function(data) {
				$scope.projectList = data;
			});
		} ]
	}

});