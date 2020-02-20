var app = angular.module('helloApp', []);

app.service('driver', function DriverData(){
	var driverName;
	var driverCity;
	var driverState;
	var driverAge;
	var driverPd;
	var driverDE;
	var driverEmail;
	var dmvEligibility=false;
	var licenseCategory;
	this.getLicenseCategory=function(){
		return licenseCategory;
	}
	this.setLicenseCategory=function(licenseCategory){
		this.licenseCategory = licenseCategory;
	}
	
	this.getDriverCity=function() {
		return driverCity;
	}

	this.setDriverCity= function(driverCity) {
		this.driverCity = driverCity;
	}

	this.getDriverState=function() {
		return driverState;
	}

	this.setDriverState=function(driverState) {
		this.driverState = driverState;
	}

	this.getDriverAge=function() {
		return driverAge;
	}

	this.setDriverAge=function(driverAge) {
		this.driverAge = driverAge;
	}

	this.getDriverPd=function() {
		return driverPd;
	}

	this.setDriverPd=function(driverPd) {
		this.driverPd = driverPd;
	}

	this.getDriverDE=function() {
		return driverDE;
	}

	this.setDriverDE=function(driverDE) {
		this.driverDE = driverDE;
	}

	this.getDriverEmail=function() {
		return driverEmail;
	}
	this.setDriverEmail = function(driverEmail) {
		this.driverEmail = driverEmail;
	}	
	this.setDriverName = function(name){
		driverName = name;
	}
	this.getDriverName = function(){
		return driverName;
	}
	this.driverdmvEligibility = function(dmvEligibility){
		dmvEligibility = true;
	}
	this.isDriverDmvEligible = function(){
		return dmvEligibility;
	}
});

app.controller("checkEligibilityCtrl", function($scope, $http, $window, driver){
	$scope.checkEligibility = function(){
		var name= $scope.name;
        var email = $scope.email;
        var driverage = $scope.age;
        var pd = $scope.previousDate;
        var drivercity = $scope.city;
        var driverstate = $scope.state;
        var driverdrivingExperience = $scope.experience;
    
        driver.setDriverName(name);
        driver.setDriverEmail(email);
        driver.setDriverAge(driverage);
        driver.setDriverCity(drivercity);
        driver.setDriverState(driverstate);
        driver.setDriverDE(driverdrivingExperience);
        driver.setDriverPd(pd);
//	        $http({
//	            url: "http://localhost:9090/DecisionService/rest/v1/IDL_NewRulesApp/issuing_license_decision_service/1.2",
//	            method:'POST', 
//	            headers: {'Content-Type': 'application/json'},
//	            data:{
//	            "driver": {
//	                  "previousDate": pd,
//	                  "city": drivercity,
//	                  "age": driverage,
//	                  "state":driverstate,
//	                  "drivingExperience": driverdrivingExperience
//	                }
//	            }
//	    }).then(function success(response){         
//	        if(response.data.dmvEligibility==true){
//	            driver.driverdmvEligibility();	
//	            console.log("Good try");
//	    	}
//	        else{
//	            alert('invalid login');
//	        }
//	            console.log(response.data);
//	            $scope.Output = response.data;
//	            driver.setDriverName(name);
//	            driver.setDriverEmail(email);
//	            driver.setDriverAge(driverage);
//	            driver.setDriverCity(drivercity);
//	            driver.setDriverState(driverstate);
//	            driver.setDriverDE(driverdrivingExperience);
//	            driver.setDriverPd(pd);
//	        },function error(response){
//	            console.log("error found");
//	        }
//	        );
	    }	    
});

app.controller("showDataCtrl", function($scope, $http, driver){
	$scope.showData = function(){
		$scope.name = driver.getDriverName();
		$scope.age = driver.getDriverAge();	
	}	
});