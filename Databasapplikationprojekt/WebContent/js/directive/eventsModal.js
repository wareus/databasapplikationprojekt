

angular.module('eventsModalButtonDirective', ['mm.foundation']).directive('eventsModalButton', function() {

	return {
		restrict : 'E',
		template : '<button ng-click="eventsModalButtonClick()">Events</button>',
		controller : [ '$scope', '$modal', function($scope,$modal) {
			$scope.eventsModalButtonClick = function()
			{
			    var modalInstance = $modal.open({
			        templateUrl: 'html/modal/eventsModal.html',
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