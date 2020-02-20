var outputapp = angular.module('outputApp', []);

//outputapp.controller('checkEligibilityCtrl', function($scope, $http){
//	alert("hello user");
//});

outputapp.controller('checkDetailsCtrl', function($scope, $http){	
		$scope.driver = {
				email: "",
				familyMembersCount: "",				
				licenseRevokedDate: ""
		};
		$scope.fetchDetails = function(){			
			console.log("hello");

		$http({
			method:'POST',
			url:'/setEmail',
			data: angular.toJson($scope.driver),
			headers:{'Content-Type':'application/json'}
		}).then(function success(response){
			console.log(response.data);
			if(response.data.licenseEligibility == true){
//				<h3><b>Congratulations! You are eligible for driving license.</b></h3>
				$scope.msgStyle = {
						"color": "green"
				}
				$scope.msg = "Congratulations! You are eligible for driving license.";
				$scope.licenseEligibility = "Eligible";
			}
			else{
				$scope.msgStyle = {
						"color": "red"
				}
				$scope.msg = "Sorry! You are not eligible for driving license.";
				$scope.licenseEligibility = "Not Eligible";
			}
				$scope.city = response.data.city;
				$scope.name = response.data.name;
				$scope.email = response.data.email;
				$scope.age = response.data.age;
				$scope.state = response.data.state;
				$scope.experience = response.data.drivingExperience;
				$scope.previousDate = response.data.previousDate;
				$scope.licenseRevokedDate = response.data.licenseRevokedDate;
				$scope.familyMembersCount =response.data.familyMembersCount;
				
//				output
				$scope.licenseCategory = response.data.licenseCategory;
						
		}, 
		function error(response){
			console.log("error found");
			console.log(response.data);
		})		
	}
});

//<div class="text-sucess text-center" id="showInvalid">
//<h3><b>Sorry! You are not eligible for license.</b></h3> 
//</div>