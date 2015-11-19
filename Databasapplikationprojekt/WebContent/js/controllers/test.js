angular.module('test', ['dto','login'])
.controller("testController", function($scope, User, Login){
	
	console.log("test");
	
	$scope.get = function()
	{
		User.get({id:1},function(data) {
			console.log(data);
		});
		
	}
	$scope.query = function()
	{
		User.query(function(data) {
			console.log(data);
		});
	}
	$scope.save = function()
	{
		new User({name:"name", rights:2, password:"passsword"}).$save();
		
	}
	$scope.update = function()
	{
		User.query(function(data) {
			user = data[data.length-1];
			user.name = "Updated";
			new User(user).$update();
		});
		
		
	}
	$scope.remove = function()
	{
		console.log("remove");
		new User({id:1}).$remove();
	}
	
	
	
	
})
