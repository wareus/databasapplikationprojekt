

angular.module('loginModalButtonDirective', ['mm.foundation']).directive('loginModalButton', function() {

	return {
		restrict : 'E',
		template : '<button ng-click="loginModalButtonClick()">Login</button>',
		controller : [ '$scope', '$modal', function($scope,$modal) {
			$scope.loginModalButtonClick = function()
			{
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
		} ]
	}

});