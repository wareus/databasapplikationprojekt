angular.module('errorHandler', ['mm.foundation']).config(['$httpProvider', function ($httpProvider) {

	var loginModalOpen = false;
	
	$httpProvider.interceptors.push(function($q, $injector, $location) {

			
		
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
						        backdrop : 'static',
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
			        else if(response.status === 406)
			        {
			        	$location.path("projectView");
			        }
			        
			        if(response.data.header !== undefined && response.data.message !== undefined)
			        {
			        	alert(response.data.header, response.data.message);
			        	console.log(response);
			        }
			        
			        
			        return $q.reject(response);
			      }

		};
	});
	
    }]);
