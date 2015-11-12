angular.module('api', ['ngResource'])
.service('API', function($resource) {
	
	return function(path){
		return $resource(
				path + "/:id",
				{id:'@id'}, 
				{
					update: {method:'PUT'},
					remove: {method:'DELETE'}
				});
	};

});