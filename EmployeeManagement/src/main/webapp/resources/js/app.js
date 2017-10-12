/** Angular Controller *//
var app = angular.module('myApp', ['ngResource']);

app.factory('Employee', ['$resource', function($resource) {
    return $resource('http://localhost:8080/EmployeeManagement/info/employee/:employeeId', {
        employeeId: '@eid'
    }, {
        updateEmployee: {
            method: 'PUT'
        }
    });
}]);

app.controller('EmployeeController', ['$scope', 'Employee', function($scope, Employee) {
    var ob = this;
    ob.employees = [];
    ob.employee = new Employee();
    ob.fetchAllEmployees = function() {
        ob.employees = Employee.query();
    };
    ob.fetchAllEmployees();
    ob.addEmployee = function() {
        console.log('Inside save');
        if ($scope.employeeForm.$valid) {
            ob.employee.$save(function(employee) {
                    console.log(employee);
                    ob.flag = 'created';
                    ob.reset();
                    ob.fetchAllEmployees();
                },
                function(err) {
                    console.log(err.status);
                    ob.flag = 'failed';
                }
            );
        }
    };
    ob.editEmployee = function(id) {
        console.log('Inside edit');
        ob.employee = Employee.get({
            employeeId: id
        }, function() {
            ob.flag = 'edit';
        });
    };
    ob.updateEmployeeDetail = function() {
        console.log('Inside update');
        if ($scope.employeeForm.$valid) {
            ob.employee.$updateEmployee(function(employee) {
                ob.updatedId = employee.eid;
                ob.reset();
                ob.flag = 'updated';
                ob.fetchAllEmployees();
            });
        }
    };
    ob.deleteEmployee = function(id) {
        console.log('Inside delete');
        ob.employee = Employee.delete({
            employeeId: id
        }, function() {
            ob.reset();
            ob.flag = 'deleted';
            ob.fetchAllEmployees();
        });
    };
    ob.reset = function() {
        ob.employee = new Employee();
        $scope.employeeForm.$setPristine();
    };
    ob.cancelUpdate = function(id) {
        ob.employee = new Employee();
        ob.flag = '';
        ob.fetchAllEmployees();
    };
}]);