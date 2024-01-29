<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="com.jci.model.Jciclaim_NominationModel"%>
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
                <h1 class="page-title">Nomination of Officials for Claim Settlement</h1>
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
                       <form action="savenominal.obj" method="POST">
                                 <div class="row">
                                 
		                                       <div class="col-sm-4 form-group">
											<label> Mill</label>
											 <span class="text-danger">*
											</span>
											 <select name="Mill" id="Mill"
												class="form-control taxtbox" required>
												<option value="">Select</option>

												<c:forEach items="${millid}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>


											</select>
										</div>
                                       
										
										
										     <div class="col-sm-4 form-group">
		                                             <label>Contract No</label>
		                                        		 <select name="ContractNo" id="ContractNo"
												class="form-control taxtbox" required>
												<option value="">Select</option>

												<c:forEach items="${contractno}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>


											</select>
	                                        </div>
										
										 <div class="col-sm-4 form-group">
	                                             <label>Challan No</label>
	                                             <input class="form-control taxtbox" name="ChallanNo" id="ChallanNo" type="text"  required>
	                                       </div>
                                 </div>
                                    
                                   <div class="row">
                                   
                                           <div class="col-sm-4 form-group">
	                                             <label>MR No</label>
	                                             <input class="form-control taxtbox" name="MRNo" id="MRNo" type="text" required>
	                                       </div>
	                                     
	                                       <div class="col-sm-4 form-group">
	                                             <label>Bale Mark</label>
	                                             <input class="form-control taxtbox" id="BaleMark" name="BaleMark" type="text"  required>
	                                       </div>
	                                       
		                                   <div class="col-sm-4 form-group">
		                                             <label>Jute Variety Grade wise</label>
		                                        	 <select  id="jutegrade" name="jutegrade" class="form-control taxtbox" required>
		                                        		<option value="">-Select-</option>
		                                        		<option value="a">A</option>
		                                        		<option value="b">B</option>
		                                        		<option value="c">C</option>
		                                        	</select>
	                                        </div>
	                                       
                                    </div>
                                    
                                     
                                        <div class="row">
                                        
                                          <div class="col-sm-4 form-group">
	                                             <label>Crop Year</label>
	                                             <input class="form-control taxtbox" name="CropYear" id="CropYear" type="text" placeholder="Crop Year" required>
	                                       </div>
                                   
                                            <div class="col-sm-4 form-group">
	                                             <label>Quality Claim</label>
	                                             <input class="form-control taxtbox" name="QualityClaim" id="QualityClaim" type="text" placeholder="  Quality Claim" required>
	                                       </div>
	                                     
	                                         <div class="col-sm-4 form-group">
	                                             <label>Moisture Content</label>
	                                             <input class="form-control taxtbox" name="MoistureContent" id="MoistureContent" type="number" placeholder ="Moisture Content" required>
	                                       </div>
	                                       
                                    </div>
                                    <div class="row">
                                    
                                        <div class="col-sm-4 form-group">
												<label>NCV Percentage</label> 
												<input class="form-control" name="NCVPercentage" id="NCVPercentage" type="number">
										</div>
                                   
	                                       <div class="col-sm-4 form-group">
	                                             <label>Claim Amount</label>
	                                             <input class="form-control taxtbox" name="ClaimAmount" id="ClaimAmount" min="0" type="number" >
	                                       </div>
	                                       
	                                       
	                                       
	                                       	<div class="col-sm-4 form-group">
											<label>O&M Official</label>
											 <span class="text-danger">*
											</span>
											 <select name="omofficial" id="omofficial"
												class="form-control taxtbox" required>
												<option value="">Select</option>

												<c:forEach items="${OM_official}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>


											        </select>
											        </div>
	                                
	                         
	                                    
                                   </div>
                                   
                                     <div class="row">
                                     
	                                       	<div class="col-sm-4 form-group">
											<label>F&A Official</label>
											 <span class="text-danger">*
											</span>
											 <select name="FAofficial" id="FAofficial"
												class="form-control taxtbox" required>
												<option value="">Select</option>

												<c:forEach items="${FA_official}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>


											</select>
	                                     
                                              </div>
                                     
                                    
                                       <div class="col-sm-4 form-group">
											<label> Date of Inspection</label> 
											<input class="form-control taxtbox" id="DateofInpection" name="DateofInpection" type="date" placeholder="Enter Date of Inspection" required>
									  </div>
		                                       
                                         <div class="col-sm-4 form-group">
	                                             <label> Settlement Id</label>
	                                             <input class="form-control taxtbox" name="SettlementId" id="SettlementId" type="number" required>
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
    
    <script type="text/javascript">
    
	$(document).ready(function(){
		 $("#submit").click(function(){
		//  Write code if Required
			  
		    });
	 });
		
	</script>
	
	
<!-- <script type="text/javascript">

$(document).ready(function()
		{
	
	
	alert("This IS MY Testing Alert for Nomination of Sattlement!!!");
		});
	

</script> -->
	
<!-- 	AJAX Call for Fetching Mill Receipt Data -->

	<script type="text/javascript">
	
	
	// Wait for the document to be ready
	$(document).ready(function() {
	  // Add an event listener for the change event on the dropdown
	  alert("This Is My Nomination Page of Satlement");
	  $('#Mill').on('change', function() {
	    // Get the selected option value
	    var selectedOption = $(this).val();
	    
	    alert(selectedOption);
	   

	    // Make an AJAX call to fetch data based on the selected value
	    $.ajax({
	      type: 'GET',  // You can adjust the HTTP method as needed (e.g., POST)
	      url: 'fetchmillreceiptdata.obj', // Replace with the actual API endpoint
	      data: { millid: selectedOption }, // Pass the selected option to the server
	      success: function(data) {
	        // Handle the response data and display it.
	       
	        
	        alert(data);
	        
	         // Parse the JSON response
             var response = JSON.parse(data);
	        
	      

             
             
	        
	   
	        
	        var innerArray1 = response[0];
	    
	        
	       

	          // Access the elements within the inner array
	          var ChallanNo =   innerArray1[0];
	          var MRNo = innerArray1[1];
	          var BaleMark= innerArray1[2];
	          var CropYear =   innerArray1[3];
	          var QualityClaim = innerArray1[4];
	          var MoistureContent= innerArray1[5];
	          var NCVPercentage =   innerArray1[6];
	         
	         
	          // For DateofInpection value settingbased on MRs
	          var DateofInpection= MRNo+"0";
	         
	          
	        
	           $('#ChallanNo').val(ChallanNo); // Setting Data In JSP Text Field

	           $('#MRNo').val(MRNo);
	           $('#BaleMark').val(BaleMark);
	           $('#CropYear').val(CropYear); 
	           $('#QualityClaim').val(QualityClaim); 
	           $('#MoistureContent').val(MoistureContent); 
	           $('#NCVPercentage').val(NCVPercentage); 
 
           // Generating the Settlement id using MRNo
           <%
                Jciclaim_NominationModel jciclaim_NominationModel=new Jciclaim_NominationModel();
                Long id= jciclaim_NominationModel. getSettlement_id();
                System.err.println("this is id Generated Automatic "+id);
                System.err.println("this is id Generated Automatic "+id);
                System.err.println("this is id Generated Automatic "+id);
                System.err.println("this is id Generated Automatic "+id);
                System.err.println("this is id Generated Automatic "+id);
                System.err.println("this is id Generated Automatic "+id);
                System.err.println("this is id Generated Automatic "+id);
               
               
           %>
           
              var Settlementid =MRNo;
	       
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