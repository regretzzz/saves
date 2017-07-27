var app = angular.module("personApp", []);
app.controller("personController", function($scope, $http, $httpParamSerializer) {
	$scope.addUpdate = "VELASCO";
	
	$scope.storePerson = function() {
		$scope.createPerson();
	}
	
	$scope.createPerson = function(){
		var jsonData = {
				fName: $scope.firstName,
				lName: $scope.lastName,
				address: $scope.address,
				age: $scope.age
		};
		
		$http.post("/CreatePerson", $httpParamSerializer(jsonData),
				{
					headers: {'Content-Type': 'application/x-www-form-urlencoded'}
				}
			)
			.then(function(response) {
				if (response.data.errorList.length == 0) {
					alert("Successfully Added Item");
					$scope.clearAllFields();
				} else {
					var errorMessage = "";
					for (var i = 0; i < response.data.errorList.length; i++) {
						errorMessage += response.data.errorList[i] += "\n";
					}
					alert(errorMessage);
				}
			}, function() {
				alert("An error has occured");
			});
	}
	
	$scope.clearAllFields = function() {
		$scope.idField = "";
		$scope.firstName = "";
	    $scope.lastName = "";
	    $scope.address = "";
	    $scope.age = "";
	    $scope.addUpdate = "ADD";
	}
	
});