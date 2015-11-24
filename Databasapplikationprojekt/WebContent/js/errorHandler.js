angular.module('errorHandler', ['mm.foundation']).config(['$httpProvider', function ($httpProvider) {

	
	$httpProvider.interceptors.push(function($q, $injector) {

			
		
		return{
			       'responseError': function(response) {
			        if(response.status === 401)
			        {
			        	var $modal;
			        	$modal = $modal || $injector.get('$modal');
			        	var modalInstance = $modal.open({
					        templateUrl: 'html/modal/loginModal.html',
					        controller: function($scope,$modalInstance)
					        {
					        	 $scope.cancel = function () {
					        		 $modalInstance.dismiss('cancel');
					        	};
					        }
					    });
			        }
			        return $q.reject(response);
			      }

		};
	});
	
    }]);