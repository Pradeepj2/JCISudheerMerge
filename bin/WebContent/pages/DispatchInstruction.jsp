<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.jci.model.RoDetailsModel"%>
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
<link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<!-- PLUGINS STYLES-->
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
	</script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="assets/css/chosen.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.js"></script>   

	
<!-- CORE SCRIPTS-->
<style>
.required:after {
	content: " *";
	color: red;
}
</style>






</head>
<body class="fixed-navbar" onload="myFunction()">


	<%
	int regionCode = (Integer) request.getAttribute("regionCode");
	LocalDate obj = LocalDate.now();
	//LocalDate obj = LocalDate.of(2020, 1, 8)

	int currentyear = obj.getYear();
	int nextyear = 0;
	int month = obj.getMonthValue();

	if (month >= 7) {
		nextyear = currentyear + 1;
	} else {
		nextyear = currentyear;
		currentyear -= 1;
	}

	String cropYear = currentyear + "-" + nextyear;
	int totalrow = (Integer) request.getAttribute("total") + 1;

	String DiNo = cropYear + "/0" + regionCode + "00" + totalrow;

	/*  int fctotal=(Integer) request.getAttribute("fctotal"); */
	%>



	<div class="page-wrapper">
		<!-- START HEADER-->
		<%--  <%@ include file="header.jsp"%   Commented by me> --%>
		<!-- END HEADER-->
		<!-- START SIDEBAR-->
		<%@ include file="sidebar.jsp"%>
		<!-- END SIDEBAR-->
		<div class="content-wrapper">
			<!-- START PAGE CONTENT-->
			<div class="page-heading">
				<h1 class="page-title">Dispatch Instruction (HO)</h1>
				<h1>
				
					<%-- <%=totalrow%></h1> --%>
			</div>
			<div>

				<%-- <h1>${fctotal}</h1> --%>
			</div>

			<%
			// Author vishal
			%>

			





			<div class="page-content fade-in-up">
				<div class="row">
					<div class="col-md-11">
						<div class="ibox">
							<%--    <span>${msg}</span> --%>
							<div class="ibox-body">
								<form action="dispatchHoInstruction.obj" method="POST" onsubmit=" return validate() && validateForm()">
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
											<label>Contract Date </label>
											 <input class="form-control"
												name="ContractDate" 
												id="ContractDate" 
												type="text"  readonly="readonly">
										</div>





										<div class="col-sm-4 form-group">
											<label>Crop year</label> 
											<input class="form-control taxtbox"
												name="Cropyear" 
												id="Cropyear"
												type="text" 
												value="<%=cropYear%>"
												placeholder="Crop Year"
												readonly="readonly">
										</div>
									</div>

									<div class="row">




										<div class="col-sm-4 form-group">
											<label>FC Ref No.</label>
											 <span class="text-danger">*</span> 
											  <input class="form-control"
												name="FCRefNo" 
												id="FCRefNo" 
												type="text" readonly="readonly">
											<%-- 	
											<select name="FCRefNo" id="FCRefNo" 
												class="form-control taxtbox" required >
												<option   value="">Select</option>

												<c:forEach items="${f}" var="item">
													<option  value="${item}">${item}</option>
												</c:forEach> 


											</select> --%>
											
										</div>




										


                                	<div class="col-sm-4 form-group">
											<label>Contracted Qty</label>
											 <span class="text-danger">*</span> 
											 <input class="form-control"
												name="ContractedQty" 
												id="ContractedQty" 
												type="text" required readonly="readonly">
											 
											
											<%-- <select name="ContractedQty" id="ContractedQty" 
												class="form-control taxtbox" required >
												<option   value="">Select</option>

												<c:forEach items="${Contract_qty}" var="item">
													<option  value="${item}">${item}</option>
												</c:forEach>


											</select> --%>
											
										</div>


										<div class="col-sm-4 form-group">
											<label>Allowed Qty</label> <span class="text-danger">*
											</span> 
											<input class="form-control"
												name="AllowedQty" 
												id="AllowedQty" 
												type="text" required readonly="readonly">
											
											
										<%-- 	<select name="AllowedQty" id="AllowedQty"
												class="form-control taxtbox" required>
												<option value="">Select</option>

												<c:forEach items="${allowqty}" var="item">
													<option value="${item}">${item}</option>
												</c:forEach>


											</select> --%>
										
										</div>




									</div>
										<div class="row">


										<div class="col-sm-4 form-group">
											<label id="regionlabel"  class="required">Region</label>
											<%
												List<RoDetailsModel> regionlist = (List<RoDetailsModel>) request.getAttribute("RegionList");
											%>
											<select class="form-control" name="region" id="region">
												<option disabled selected value>-Select-</option>
												<%
													for(RoDetailsModel regions : regionlist) {
												%>
												<option value="<%=regions.getRocode()%>"><%=regions.getRoname()%></option>
												<%
													}
												%>
											</select>
											<!-- <input class="form-control" type="text" name="zone" placeholder="Zone"> -->
										</div>




										 	
										<div class="col-sm-4 form-group" id="dpc_div">
										
										
								<!-- 		 <label for="enableDropdown">Enable Dropdown:</label>
                                          <input type="checkbox" id="enableDropdown"> -->
                                          
										
											<label id="dpclabel" class="required">DPC</label> &nbsp;&nbsp;&nbsp;
											  <select class="form-control" id="dpc_div" style=display: none" dpc" >
											  <option selected disabled></option>
											  </select> 
											
										</div>


										<div class="col-sm-4 form-group">
											<label>Last date of Shipment</label> <input
												class="form-control" name="LastdateofShipment"
												id="LastdateofShipment" type="text" readonly="readonly" >
										</div>

									</div>
									<div class="row">



										<div class="col-sm-4 form-group">
											<label>DI No</label> <input class="form-control taxtbox"
												value="<%=DiNo%>" name="DINo" type="text"
												id="DINo"
												placeholder="DI No." readonly="readonly">
										</div>

						
										<div class="col-sm-4 form-group">
											<label>DI Date</label> <input class="form-control taxtbox"
												name="DIDate" id="DIDate"
												type="text" value= "${currentDate}" 
												readonly="readonly">
										</div>


										<div class="col-sm-4 form-group">
											<label>Jute Variety</label> <span class="text-danger">*
											</span> <select name="JuteVariety" id="JuteVariety"
												class="form-control taxtbox" required>
												<option value="">Select</option>
												<option value="Bimli">Bimli</option>
												<option value="Mesta">Mesta</option>
												<option value="Tossa">Tossa</option>
												<option value="White">White</option>
											</select>
										</div>
									</div>
									<div class="row">

								





										<div class="col-sm-4 form-group">
											<label>Remarks </label>
											 <input class="form-control taxtbox "
												name="Remarks" id="Remarks"  type="text"  
												
												required>
												<p id="validationMessage"></p>  
									</div>
                                       
                                   
                                    

										<div class="col-sm-4 form-group">
										
												
												
       <div><label class="label1" >Enter Grade Wise Allocation</label> </div>
        <label for="grade1" class="label1">Grade 1:</label>
        <input type="text" id="grade1" class="grade" name="grade1" value="0"><br>

        <label for="grade2" class="label1" >Grade 2:</label>
        <input type="text" id="grade2" name="grade2" class="grade" value="0"><br>

        <label for="grade3" class="label1" >Grade 3:</label>
        <input type="text" id="grade3" name="grade3" class="grade" value="0"><br>

        <label for="grade4" class="label1">Grade 4:</label>
        <input type="text" id="grade4" name="grade4"  class="grade" value="0"><br>

        <label for="grade5" class="label1">Grade 5:</label>
        <input type="text" id="grade5" name="grade5" class="grade" value="0"><br>

        <label for="grade6"  class="label1">Grade 6:</label>
        <input type="text" id="grade6" name="grade6" class="grade" value="0"><br>

        <label for="grade7" class="label1">Grade 7:</label>
        <input type="text" id="grade7" name="grade7" class="grade" value="0"><br>

        <label for="grade8" class="label1">Grade 8:</label>
        <input type="text" id="grade8" name="grade8" class="grade" value="0"><br>
				
		<small style="color:red" id="error"></small>								
												
									</div>
   		

									</div>

								
									<br>
									<div class="row">

										<div class="col-sm-12 form-group">
											<input type="submit" value="Submit" class="btn btn-primary" 
												id="submit">
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
 	$("#region").on("change", function() {
			var id = (this.value);	
			var html = "<label id='dpclabel' class='required'>DPC</label> <select data-placeholder='Choose DPC...' class='chosen-select form-control' id='centerordpc' multiple tabindex='3' name='dpc' >";
			if(id!=null){
				$.ajax({
					type:"GET",
					url:"findDpcByRegion.obj",
					data:{"id":id},
					success:function(result){
		 				   var data= jQuery.parseJSON(result);
		 				//   alert(data);
	 	 					  html += "";
		 				     for (var i = 0; i< data.length; i++){
		 				   	   
		 					 html += "<option value=" +data[i].split("-")[1]+">"+data[i].split("-")[1]+"</option>";
		 				  } 
		 				     
		 				     html += '</select>';
		 				     
		 				     
		 				     
		 				$("#dpc_div").html(html);
		 				
		 				/* //Hiding logic Implementation
		 				 $("#enableDropdown").change(function () {
                          if ($(this).is(":checked")) {
                            //$("#dpc_div").show();
                            $("#dpc_div").html(html)
                              } else {
                                $("#dpc_div").hide();
                                    }
		 				// close */
		 				
		 				$("#centerordpc").chosen();
		 	
		 				 $('#centerordpc option').prop('selected', true);  
	 					 $('#centerordpc').trigger('chosen:updated');
		 			     
					}			
				});
			} 
		});
     });
	</script>

	<script>
		$("#multiro")
				.on(
						"change",
						function() {
							var id = $(this).val();
						 	$
									.ajax({
										type : "GET",
										url : "findroname.obj",
										data : {
											'id' : id
										},
										success : function(result) {
											var data = jQuery.parseJSON(result);

											console.log(data , "result");
											var html = "<option disabled selected value>-Select-</option>";
											for (var i = 0; i < data.length; i++) {

												html += "<option value=" +data[i]+">"
														+ data[i] + "</option>";
												// alert(data);
											}
											$("#dpc").html(html);

										}

									});
						});
	</script>


<!--   sending data throgh AJax  call to controller.
 -->
  


	<!-- END PAGA BACKDROPS-->
	<!-- CORE PLUGINS-->
	<script src="./assets/vendors/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/popper.js/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="./assets/vendors/metisMenu/dist/metisMenu.min.js"
		type="text/javascript"></script>
	<script
		src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- PAGE LEVEL PLUGINS-->
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>



      <script src="assets/css/chosen.jquery.js" type="text/javascript"></script>
  <script src="assets/css/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
  <script src="assets/css/docsupport/init.js" type="text/javascript" charset="utf-8"></script>


	<!-- PAGE LEVEL SCRIPTS-->

<script>

 /*   Adding Event Listner that allowed Only Non Negative Number */
 
 

 
        // Function to validate input fields
        function validateNonPositive(inputElement) {
            inputElement.addEventListener("input", function (e) {
                // Get the current input value
                const inputValue = e.target.value;

                // Use a regular expression to check if the input consists of only alphanumeric characters

                const isDigitOnly = /^\d*$/.test(inputValue);

            if (!isDigitOnly) {
                // If the input is not a digit, remove non-digit characters
                e.target.value = inputValue.replace(/\D/g, "");
            }
            
            });
        }

        // Get all input fields with the class "alphaNumericInput" and apply the validation function
        const DigitInputs = document.querySelectorAll(".onlydigit");
        DigitInputs.forEach(validateNonPositive);

       
        </script>
        
        
        
<!--    Applying Ajax Call Here  for sending data of Financial Concurrence-->
	<script type="text/javascript">
	
	
	// Wait for the document to be ready
	$(document).ready(function() {
	  // Add an event listener for the change event on the dropdown
	  
	  $('#ContractNo').on('change', function() {
	    // Get the selected option value
	    var selectedOption = $(this).val();
	   

	    // Make an AJAX call to fetch data based on the selected value
	    $.ajax({
	      type: 'GET',  // You can adjust the HTTP method as needed (e.g., POST)
	      url: 'contractnoforfc.obj', // Replace with the actual API endpoint
	      data: { contractno: selectedOption }, // Pass the selected option to the server
	      success: function(data) {
	        // Handle the response data and display it.
	       
	        
	        
	         // Parse the JSON response
             var response = JSON.parse(data);
	         
	      

             // Access FcTableData and AdditionalData
             var FcTableData = response.FcTableData;
             var LastDateShipment = response.LastDateShipment;
	        
	     
	        
	        var innerArray1 = FcTableData[0];
	    
	        
	       

	          // Access the elements within the inner array
	          var Contract_date =   innerArray1[0];
	          var fcRef = innerArray1[1];
	          var ContractedQty= innerArray1[2];
	          var AllowedQty =   innerArray1[3];
	         
	          
	         
	          
	        
	           $('#ContractDate').val(Contract_date); // Setting Data In JSP Text Field

	           $('#FCRefNo').val(fcRef);
	           $('#ContractedQty').val(ContractedQty);
	           $('#AllowedQty').val(AllowedQty); 
	           $('#LastdateofShipment').val(LastDateShipment); 

         
	       
	      }, 
	      error: function(err) {
	        // Handle errors here
	        console.error('AJAX request failed: ' + err);
	      }
	    });
	  });
	});

	
	</script>


  
<script>
    function validateText(inputText) {
      // Define a regular expression to match valid text (letters and spaces)
      var regex = /^[A-Za-z\s]+$/;
      return regex.test(inputText);
    }

    function validateForm() {
    	
      var Remarks = document.getElementById("Remarks").value;
      var validationMessage = document.getElementById("validationMessage");

      if (validateText(Remarks)) {
        validationMessage.textContent = "Valid text input.";
        validationMessage.style.color = "green";
        return true; // Allow the form to submit
      } else {
        validationMessage.textContent = "Invalid input. Please enter letters and spaces only.";
        validationMessage.style.color = "red";
        return false; // Prevent the form from submitting
      }
    }
  </script>
  
<script>
$(function(){
	
$('.grade').hide();

 $('.label1').hide();
	  
	    
  $('#JuteVariety').on("change", function(){
    var variety = $(this).val();
   
   // if (variety == 'Tossa' || variety == 'White') 
  
	if (variety == 'Bimli' || variety == 'Mesta') {

		 $(".grade").show();
		 $('.label1').show();
		 
		 $("#grade7, label[for='grade7']").hide();
		 $("#grade8, label[for='grade8']").hide();
		 //$("#grade7").hide();
		 //$('#grade8').hide();
     }
   
   
	 if (variety == 'Tossa' || variety == 'White') 
	{
		 
		 $(".grade").fadeIn();
		 
		 $('.label1').show();
	}
	 
	 if(variety == ''){
		 
		 $('.grade').hide();

		 $('.label1').hide();
        }
          
		 

		});
	});
</script>

  
 
     
<script>
         function validate() {
            // Get the input field element by its ID

            var status=true;
   
            
            // Fetching Value of Grade Allocation.
            var g1= Number(document.getElementById("grade1").value);
            var g2=Number (document.getElementById("grade2").value);
            var g3= Number(document.getElementById("grade3").value);
            var g4= Number(document.getElementById("grade4").value);
            var g5= Number(document.getElementById("grade5").value);
            var g6= Number(document.getElementById("grade6").value);
            var g7= Number(document.getElementById("grade7").value);
            var g8= Number(document.getElementById("grade8").value);
            
        
            	var total=g1+g2+g3+g4+g5+g6+g7+g8;
            
    
            
            
            
            var AllowedQty= Number(document.getElementById("AllowedQty").value);
          
          
            
            if(AllowedQty!=total)
            	{
            	status=false;

            	document.getElementById("error").innerHTML="Sum Should Be Equal to Allowed Qty i.e =" + AllowedQty;
            	
            	}
           
            return status;
          
        } 
        
    </script>	
  

	
</body>
</html>