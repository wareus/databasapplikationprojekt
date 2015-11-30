

angular.module('eventModalButtonDirective', ['mm.foundation']).directive('eventModalButton', function() {

	return {
		
		restrict : 'E',
		template : '<button ng-click="eventModalButtonClick()">Add event</button>',
		controller : [ '$scope', '$modal', function($scope,$modal) {
			$scope.eventModalButtonClick = function()
			{
			    var modalInstance = $modal.open({
			        templateUrl: 'html/modal/eventModal.html',
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