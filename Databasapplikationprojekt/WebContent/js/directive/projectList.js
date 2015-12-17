angular.module('projectListDirective', ['dto']).directive('projectList', function(Project) {

	return {
		restrict : 'E',

		templateUrl : 'html/directive/projectList.html',

		controller : [ '$scope', function($scope) {
			$scope.categories = CATEGORIES;
			$scope.projectList = {
				selectCategory:function(id,category)
				{
					new Project({id:id,kategori:category}).$update();
				},
				select:function(id)
				{
					Project.select(id);
				},
				delete:function(id)
				{
					new Project({id:id}).$remove(function()
					{
						$scope.projectList.update();
						
					});
				},
				update:function()
				{
					Project.yourProjects(function(data) {
						$scope.projectList.data = data;
						console.log($scope.projectList);
					});
				}
			};
			$scope.projectList.update();
		} ]
	}

});