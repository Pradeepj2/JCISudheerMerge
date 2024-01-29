<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
       <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>JCI | CMS</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    <!-- PLUGINS STYLES-->
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
     <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- CORE SCRIPTS-->
 <style>
.required:after {
	content: " *";
	color: red;
}
</style> 
</head>
<body class="fixed-navbar" onload="myFunction()">
    <div class="page-wrapper">
        <!-- START HEADER-->
        <%@ include file="header.jsp"%>
        <!-- END HEADER-->
        <!-- START SIDEBAR-->
        <%@ include file="sidebar.jsp"%>
        <!-- END SIDEBAR-->
        <div class="content-wrapper">
            <!-- START PAGE CONTENT-->
            <div class="page-heading">
                <h1 class="page-title">Mill Acceptance Form</h1>
            </div>
            
            <% 
         // Author vishal
         
            %>
            <div class="page-content fade-in-up">
                <div class="row">
                    <div class="col-md-11">
                        <div class="ibox">
                          <span>${msg}</span>
                            <div class="ibox-body">
                       <form action="savemillacceptance.obj" method="POST" enctype="multipart/form-data">
                                 <div class="row">
  
										<div class="col-sm-4 form-group">
											<label>Contract No.</label>
											 <span class="text-danger">*
											</span>
											 <select name="ContractNo" id="ContractNo"
												class="form-control taxtbox" required>
												<option value="">Select</option>

												<c:forEach items="${cno}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>


											</select>
										</div>
                                      
		                                       
                                        <div class="col-sm-4 form-group">
												<label>Contract Date</label> 
												<input class="form-control"  name="ContractDate" id="ContractDate" type="text" readonly="readonly">
										</div>
										
										 <div class="col-sm-4 form-group">
	                                             <label>Quantity</label>
	                                             <input class="form-control taxtbox" name="Quantity" id="Quantity" type="text" placeholder="Quantity" readonly="readonly" required>
	                                       </div>
                                 </div>
                                    
                                   <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>Contract Value Online</label>
	                                             <input class="form-control taxtbox" name="ContractValueOnline" id="ContractValueOnline" type="number" placeholder="ContractValueOnline" readonly="readonly">
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label>Contract Value LC</label>
	                                             <input class="form-control taxtbox" name="ContractValueLc" id="ContractValueLc" type="text" placeholder="ContractValueLc" required>
	                                       </div>
	                                       
		                                   <div class="col-sm-4 form-group">
		                                             <label>Payment Due Date</label>
		                                        	 <input type="text" name="paymentDue" id="paymentDue" class="form-control taxtbox" readonly="readonly">
		                                        		
		                                        	
	                                        </div>
	                                       
                                    </div> 
                                    
                                     
                                       <div class="row">
                                        
                                          <div class="col-sm-4 form-group">
	                                             <label>Upload Signed Doc</label>
	                                             <input class="form-control taxtbox" name="upload" id="upload" type="file" placeholder="Upload Document Optional" >
	                                       </div>
                                    
                                   </div>
                                    
                                   
                              
                                    
                                    
                                    <br>
                                        <div class="row"> 
                                        
                                                <div class="col-sm-12 form-group">
									             <input type="submit" value="Submit"class="btn btn-primary" id="submit">
									            </div>
									          </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END PAGE CONTENT-->
            <%@ include file="footer.jsp"%>
        </div>
    </div>
    
    <div class="sidenav-backdrop backdrop"></div>
   
	
<!--    Applying Ajax Call Here -->
	<script type="text/javascript">
	
	
	// Wait for the document to be ready
	$(document).ready(function() {
	  // Add an event listener for the change event on the dropdown
	  $('#ContractNo').on('change', function() {
	    // Get the selected option value
	    var selectedOption = $(this).val();
	    alert(selectedOption);

	    // Make an AJAX call to fetch data based on the selected value
	    $.ajax({
	      type: 'GET',  // You can adjust the HTTP method as needed (e.g., POST)
	      url: 'contractno.obj', // Replace with the actual API endpoint
	      data: { contractno: selectedOption }, // Pass the selected option to the server
	      success: function(data) {
	        // Handle the response data and display it in the 'result' div
	      alert(data);
	        
	        var newData=jQuery.parseJSON(data);
	        
	        alert(newData);
	     
	      var innerArray = newData[0];

          // Access the elements within the inner array
          var Contract_date =   innerArray[0];
          var Contract_qty = innerArray[1];
          var Contract_value = innerArray[2];
          var Payment_duedate =   innerArray[3];
          <!-- for calculation of Lc Value and based on  contracted value -->
          
          var ContractValueLc=(Contract_value*110)/100;
        
           $('#ContractDate').val(Contract_date); // Setting Data In JSP Text Field

           $('#Quantity').val(Contract_qty);
           $('#ContractValueOnline').val(Contract_value);
           $('#paymentDue').val(Payment_duedate);
           $('#ContractValueLc').val(ContractValueLc);
           
         
	       
	      },
	      error: function(err) {
	        // Handle errors here
	        console.error('AJAX request failed: ' + err);
	      }
	    });
	  });
	});

	
	</script>
	
	

	
	
	
    
    <!-- END PAGA BACKDROPS-->
    <!-- CORE PLUGINS-->
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    
    <!-- PAGE LEVEL SCRIPTS-->
</body>
</html>