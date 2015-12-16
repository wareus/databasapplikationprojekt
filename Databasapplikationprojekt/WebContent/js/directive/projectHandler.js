angular.module('projectHandlerDirective', ['dto']).directive('projectHandler', function(Project, UserWorksOn) {

	return {
		restrict : 'E',

		templateUrl : 'html/directive/projectHandler.html',

		controller : [ '$scope', function($scope) {
			
			$scope.categories = CATEGORIES;
			$scope.category = $scope.categories[0];
			
			$scope.projectHandler = {
				create : function(category)
				{
					new Project({name:$scope.projectHandler.projectName, kategori:category}).$save(function(data){
						UserWorksOn.connectProjectToMe(data.id, function()
						{
							update();
							
						});
					});
				},
				join:function(data)
				{
					UserWorksOn.connectProjectToMe(data.id, function()
					{
						update();
						
					});
				}
			}
			
			Project.othersProjects(function(data) {
				$scope.projectHandler.projectList = data;
			});
			
		} ]
	}

});