angular.module('errorHandler', ['mm.foundation']).config(['$httpProvider', function ($httpProvider) {

	var loginModalOpen = false;
	
	$httpProvider.interceptors.push(function($q, $injector) {

			
		
		return{
			       'responseError': function(response) {
			        if(response.status === 401)
			        {
			        	if(!loginModalOpen)
			        	{
			        		loginModalOpen = true;
				        	var $modal;
				        	$modal = $modal || $injector.get('$modal');
				        	var modalInstance = $modal.open({
						        templateUrl: 'html/modal/loginModal.html',
						        controller: function($scope, $modalInstance)
						        {
						        	 $scope.cancel = function () {
						        		 $modalInstance.dismiss('cancel');
						        		 loginModalOpen = false;
						        	};
						        }
						    });
			        	}
			        }
			        return $q.reject(response);
			      }

		};
	});
	
    }]);
