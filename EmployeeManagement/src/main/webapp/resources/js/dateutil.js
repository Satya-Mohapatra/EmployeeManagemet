/** Used to validate calender fields **/
$( function($scope) {
	    $( "#dateOfBirth" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      onSelect: function(date) { 
	    	  $scope.dateOfBirth = $(this).datepicker('getDate'); 
	    	  var selectedDate = new Date(date);
	          var endDate = new Date(selectedDate.getTime());

	          $("#dateOfEmployment").datepicker( "option", "minDate", endDate );
             
             if ($scope.dateOfEmployment != '' && $scope.dateOfEmployment != null && undefined != $scope.dateOfEmployment && (endDate > $scope.dateOfEmployment)) {
                $scope.dateOfEmployment = endDate;
             } 
         }
        }).keydown(function(e) {
        if(e.keyCode == 8 || e.keyCode == 46) {
            $.datepicker._clearDate(this);
            $( "#dateOfBirth" ).blur(); 
            e.preventDefault();
            return false;

        }
        else if (e.which != 9) {
            e.preventDefault();
            return false;
        }
    }).on("contextmenu",function(){
       return false;
    });
    });
    
	$( function($scope) {
	    $( "#dateOfEmployment" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      onSelect: function() { 
	    	  $scope.dateOfEmployment = $(this).datepicker('getDate'); 
	      }
	    }).keydown(function(e) {
	    if(e.keyCode == 8 || e.keyCode == 46) {
	        $.datepicker._clearDate(this);
            $( "#dateOfEmployment" ).blur();
            e.preventDefault();
            return false;

	    }
        else if (e.which != 9) {
            e.preventDefault();
            return false;
        }
	}).on("contextmenu",function(){
       return false;
    });
	});
