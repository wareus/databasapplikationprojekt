angular.module('projectListDirective', ['dto']).directive('projectList', function(Project) {

	return {
		restrict : 'E',

		templateUrl : 'html/directive/projectList.html',

		controller : [ '$scope', function($scope) {
			
			$scope.projectList = {
					select:function(id)
					{
						Project.select(id);
					},
					delete:function(id)
					{
						console.log(id);
						new Project({id:id}).$remove();
					}
			};
			Project.yourProjects(function(data) {
				$scope.projectList.data = data;
			});
			
		} ]
	}

});