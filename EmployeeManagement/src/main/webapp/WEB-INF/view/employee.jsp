<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta charset="UTF-8" /> 
    <title> Employee Management </title>
  </head>
  <body ng-app="myApp">
   <div ng-controller="EmployeeController as employeeCtrl">
       <h1> Employee Management </h1>
	<form name="employeeForm" method="POST">
		<div id="searchpanel" class="panel row">
			<div class="form-group col-md-4">
				<label for="name">Employee Name</label>
				<input type="text" required="true" placeholder = "Employee Name" name ="ename" class="form-control" id="ename" ng-model="employeeCtrl.employee.ename">
				<!-- <span ng-show="employeeForm.ename.$error.required" class="msg-val">Name is required.</span> -->
			</div>
			<div class="form-group col-md-4">
				<label for="mobileno">Mobile Number</label>
				<input type="text" ng-pattern="/^[0-9]{10,10}$/;" required="true" placeholder = "Mobile Number" class="form-control" id="mobileNumber" ng-model="employeeCtrl.employee.mobileNumber">
			</div>
			<div class="form-group col-md-4">
				<label for="emailAddress">Email Address</label>
				<input type="email" required="true" placeholder = "Email Address" class="form-control" id="emailAddress" ng-model="employeeCtrl.employee.emailAddress">
			</div>
			<div class="form-group col-md-4">
				<label for="dateOfBirth">Date of Birth</label>
				<input type="text"  class="form-control"  placeholder = "MM/dd/yyyy" id="dateOfBirth" >
			</div>
			<div class="form-group col-md-4">
				<label for="dateOfEmployment">Date of Employment</label>
				<input type="text"  class="form-control"  placeholder = "MM/dd/yyyy" id="dateOfEmployment" >
			</div>
			<div class="form-group col-md-4">
				<label for="location">Location</label>
				<input type="text" required="true" placeholder = "Location" class="form-control" id="location" ng-model="employeeCtrl.employee.location">
			</div>
			<div class="nopadding" style="text-align: right; padding-right:16px;">
					<input ng-if="employeeCtrl.flag != 'edit'" type="submit" value="Add Employee" ng-click="employeeCtrl.addEmployee()" class="btn btn-primary">
					<input ng-if="employeeCtrl.flag == 'edit'" type="submit" ng-click="employeeCtrl.updateEmployeeDetail()" value="Update Employee" class="btn btn-primary"/> 
					<input ng-if="employeeCtrl.flag != 'edit'" type="button" class="btn btn-secondary" ng-click="employeeCtrl.reset()" value="Reset"/>
					<input ng-if="employeeCtrl.flag == 'edit'" type="button" class="btn btn-secondary" ng-click="employeeCtrl.cancelUpdate()" value="Cancel"/>
			</div>
			<br><br>
			<div class="nopadding" style="text-align: left; padding-left:16px;">
				<span ng-if="employeeCtrl.flag=='deleted'" class="msg-success"><h3>Employee successfully deleted.</h3></span>
				<span ng-if="employeeCtrl.flag=='created'" class="msg-success"><h3>Employee successfully added.</h3></span>
			     <span ng-if="employeeCtrl.flag=='failed'" class="msg-val"><h3>Employee already exists.</h3></span> 
		    </div>
		</div>
	</form>
	<div class="panel">
        <table class="table table-striped table_size">
	      <tr><th>ID </th> <th>Name</th>  <th>Mobile No</th> <th>Email Id</th> <th>Location</th></tr>
	      <tr ng-repeat="row in employeeCtrl.employees">
	         <td><span ng-bind="row.eid"></span></td>
	         <td><span ng-bind="row.ename"></span></td>
	         <td><span ng-bind="row.mobileNumber"></span></td>
	         <td><span ng-bind="row.emailAddress"></span></td>
	         <td><span ng-bind="row.location"></span></td>
	         <td>
		    <input type="button" class="btn btn-danger" ng-click="employeeCtrl.deleteEmployee(row.eid)" value="Delete"/>
		    <input type="button" class="btn btn-primary" ng-click="employeeCtrl.editEmployee(row.eid)" value="Edit"/>
		    <span ng-if="employeeCtrl.flag=='updated' && row.eid==employeeCtrl.updatedId" class="msg-success">Employee successfully updated.</span> </td> 
	      </tr>	
	</table>
	</div>	
	</div>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- <script  src="https://code.jquery.com/jquery-3.2.1.min.js"></script> -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-resources/js/lib/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/app-resources/js/lib/angular-resource.min.js"></script>
	<script src="${pageContext.request.contextPath}/app-resources/js/app.js"></script>
	<script src="${pageContext.request.contextPath}/app-resources/js/dateutil.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app-resources/css/style.css"/>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 </body>
</html>  
  