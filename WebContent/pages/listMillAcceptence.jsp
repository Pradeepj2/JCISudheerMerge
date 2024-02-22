<%@page import="com.jci.model.JciDIHoModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.RoleMasterModel"%>
<%@page import="com.jci.model.ZoneModel"%>

<%@page import="com.jci.model.UserRegistrationModel"%>

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
<link href="./assets/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="./assets/vendors/themify-icons/css/themify-icons.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- PLUGINS STYLES-->
<link href="./assets/vendors/DataTables/datatables.min.css"
	rel="stylesheet" />
<!-- THEME STYLES-->
<link href="assets/css/main.min.css" rel="stylesheet" />
<!-- PAGE LEVEL STYLES-->
<script type="text/javascript">
	$(document).ready(function() {
		$("#farmerVerific").DataTable({
			scrollX : true,
			"pageLength" : 50
		});
	});
</script>
<style>
.scrollmenu {
	overflow: scroll;
	white-space: nowrap;
}

.scrollmenu a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px;
	text-decoration: none;
}

.tableFixHead {
	overflow: auto;
	height: 100px;
	width: 240px;
}

.tableFixHead thead th {
	position: sticky;
	top: 0;
	z-index: 1;
}

.tableFixHead tbody th {
	position: sticky;
	left: 0;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px 16px;
	white-space: nowrap;
}

th {
	background: #eee;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<!-- <script>
	function newfileupload(contract_id){
		alert(contract_id)
		 var fileInput = document.getElementById('Acceptance_doc_path');
	    //var filename = document.getElementById("Acceptence_doc_path");
		alert(fileInput + "fileInpu")
		var inputvalue = fileInput.value;
		  var file = fileInput.files[0];  // Get the selected file
           alert(file+ "file")
	        var formData = new FormData();
	        formData.append('contract_id', contract_id);
	        formData.append('Acceptance_doc_path', file);
	        alert(formData.get('Acceptance_doc_path'))
		
		alert(inputvalue)
		 $.ajax({
	            type: "POST",
	            url: "r.obj",
	            data: formData,
	            contentType: false,
	            processData: false,
	           
	            success: function (result) {
	                var data1 = jQuery.parseJSON(result);
	                alert("MMMMM");
	                alert(data1);
	               
	            },
	            error: function (err) {
	                // Handle errors here
	                console.error('AJAX request failed: ', err);
	                alert("errorrrrrrrrrrr");
	            }
	           
	           
	        });
	        window.location.reload();
		
	}
	</script> 
	 -->
<!-- <script>
    function updatemillacceptflag11(contract_id) {
        alert(contract_id);
        var fileInput = document.getElementById('Acceptance_doc_path');
    		alert(fileInput + "filename")
    		var inputvalue = fileInput.value;
    		alert(inputvalue + "inputvalue")
        var file = fileInput.files[0];  // Get the selected file

        var formData = new FormData();
        formData.append('contract_id', contract_id);
        formData.append('Acceptance_doc_path', file);

        // Debugging alerts
        alert(formData.get('Acceptance_doc_path') + " formdata");
        alert(formData.get('contract_id') + " cid");
        alert(file + " file");

        $.ajax({
            type: "POST",
            url: "r.obj",
            data: formData,
            contentType: false,
            processData: false,
            enctype: 'multipart/form-data',  // Set the enctype
            success: function (result) {
                var data = jQuery.parseJSON(result);
                alert("MMMMM");
                alert(data);
                window.location.reload();
            },
            error: function (err) {
                // Handle errors here
                console.error('AJAX request failed: ', err);
                alert("errorrrrrrrrrrr");
            }
        });
    }
</script>
 -->


<!-- <script>
    function updatemillacceptflag(contract_id) {
        alert(contract_id);
        
        var fileInput = document.getElementById('Acceptance_doc_path');
        var inputValue = fileInput.value;
        alert(inputValue + "value file")
        var file = fileInput.files[0];  // Get the selected file

        var formData = new FormData();
        formData.append('contract_id', contract_id);
        formData.append('Acceptance_doc_path', file);

        // Debugging alerts
        alert(formData.get('Acceptance_doc_path') + " formdata");
        alert(formData.get('contract_id') + "cid")
        alert(file + " file");

        $.ajax({
            type: "POST",
            url: "savemill.obj",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                var data = jQuery.parseJSON(result);
                alert("MMMMM");
                alert(data);
                window.location.reload();
            },
            error: function (err) {
                // Handle errors here
                console.error('AJAX request failed: ', err);
                alert("errorrrrrrrrrrr");
            }
        });
    }
</script> -->

<!-- <script>
    function updatemillacceptflag(contract_id) {
    	alert(contract_id)
        var fileInput = document.getElementById('Acceptance_doc_path');
        var file = fileInput.files[0];  // Get the selected file

        var formData = new FormData();
        formData.append('contract_id', contract_id);
        formData.append('Acceptance_doc_path', file);
        alert( formData.append('Acceptance_doc_path', file)  +"formdata")
        alert(file +"file")
        
        

        $.ajax({
            type: "POST",
            url: "s.obj",
            data: formData,
          /*   contentType: false, */
            processData: false,
            success: function (result) {
                var data = jQuery.parseJSON(result);
                alert("MMMMM")
                alert(data);
       window.location.reload();             },
            error : function(err) {

				// Handle errors here

				console.error('AJAX request failed: ', err);

				alert("errorrrrrrrrrrr")

			}
        	
        });

    }
</script> -->



<!--  <script>
    function updatemillacceptflag(contract_id) {
    	alert(contract_id)
        var fileInput = document.getElementById('Acceptance_doc_path');
        var file = fileInput.files[0];  // Get the selected file

        var formData = new FormData();
        formData.append('contract_id', contract_id);
        formData.append('Acceptance_doc_path', file);
        alert( formData.append('Acceptance_doc_path', file)  +"formdata")
        
        

        $.ajax({
            type: "POST",
            url: "s.obj",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                var data = jQuery.parseJSON(result);
                alert("MMMMM")
                alert(data);
            window.location.reload(); 
            }
        });
       /*  window.location.reload(); */
    }
</script> -->
<!-- <script>
    function updatemillacceptflag(contract_id) {
    	
        var fileInput = document.getElementById('Acceptance_doc_path');
        var file = fileInput.files[0];  // Get the selected file

        var formData = new FormData();
        formData.append('contract_id', contract_id);
        formData.append('Acceptance_doc_path', file);
        alert( formData.append('Acceptance_doc_path', file)  +"formdata")
        
        

        $.ajax({
            type: "GET",
            url: "s.obj",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                var data = jQuery.parseJSON(result);
                alert("MMMMM")
                alert(data);
            window.location.reload(); 
            }
        });
       /*  window.location.reload(); */
    }
</script>
 -->



<!-- 
 <script>
    function updatemillacceptflag(contract_id) {
    	alert(contract_id)
        var fileInput = document.getElementById('Acceptance_doc_path');
        var file = fileInput.files[0];  // Get the selected file

        var formData = new FormData();
        formData.append('contract_id', contract_id);
        formData.append('Acceptance_doc_path', file);
        alert( formData.append('Acceptance_doc_path', file)  +"formdata")
        
        

        $.ajax({
        	alert("ajax entry")
            type: "POST",
            url: "s.obj",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                var response = jQuery.parseJSON(result);
                alert("MMMMM")
                alert(response);
            window.location.reload(); 
            },
            error : function(err) {

				// Handle errors here

				console.error('AJAX request failed: ', err);

				alert("errorrrrrrrrrrr")

			}
        });
       /*  window.location.reload(); */
    }
</script> -->

<!-- 
<script>
	function updatemillacceptflag(contract_id ) {
		 var fileInput = document.getElementById('Acceptance_doc_path');
	        var file = fileInput.files[0];
	        alert(file)
		
		$.ajax({
			type:"GET",
			url:"sc.obj",
			data:{"contract_id":contract_id,
				"Acceptance_doc_path": acceptance_doc_path
				},
			     success:function(result){
				
 				   var data= jQuery.parseJSON(result);
 				   alert(data)
 				  
 			
 				  
			}	
			
		});
		
		 
		 window.location.reload();
	}
	</script>  -->


<!-- its working and on acceptence it is getting null -->
<!--  <script>
	function updatemillacceptflag(contract_id ) {
		
		$.ajax({
			type:"POST",
			url:"s.obj",
			data:{"contract_id":contract_id
				},
			     success:function(result){
 				   var data= jQuery.parseJSON(result);
 				   alert(data)  
			}	
			
		});
		
		 
		 window.location.reload();
	}
	</script> -->





<!-- <script>
    function updatemillacceptflag(contract_id) {
        var fileInput = document.getElementById('Acceptance_doc_path');
        var file = fileInput.files[0];  // Get the selected file

        var formData = new FormData();
        formData.append('contract_id', contract_id);
        formData.append('Acceptance_doc_path', file);

        $.ajax({
            type: "POST", // Use POST method for file uploads
            url: "setmillacceptflag.obj",
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                var data = jQuery.parseJSON(result);
                alert(data);
                window.location.reload();
            }
        });
    }
</script> -->
<!--  <script>
    function updatemillacceptflag(contract_id) {
        var fileInput = document.getElementById('Acceptance_doc_path');
        var file = fileInput.files[0];  // Get the selected file

        var formData = new FormData();
        formData.append('contract_id', contract_id);
        formData.append('Acceptance_doc_path', file);

        $.ajax({
            type: "POST", // Use POST method for file uploads
            url: "s.obj",
            data:{"contract_id":contract_id}
        
            contentType: false,
            processData: false,
            success: function (result) {
                var data = jQuery.parseJSON(result);
                alert(data);
                window.location.reload();
            }
        });
    }
</script>


<!-- <script>
	function updatemillacceptflag(contract_id ) {
		
		 var fileInput = document.getElementById('Acceptance_doc_path');
	        var file = fileInput.files[0];
	        alert(file);
	        alert("fileInput"+fileInput)
		$.ajax({
			type:"GET",
			url:"setmillacceptflag.obj",
			data:{"contract_id":contract_id,
				
				//"Acceptance_doc_path": acceptance_doc_path
				},
			success:function(result){
				
 				   var data= jQuery.parseJSON(result);
 				   alert(data)
 			
 				  
			}	
			
		});
		
		 
		 window.location.reload();
	}
	</script> -->

<!-- <script>
	function updatemillacceptflag(contract_id ) {
		
		 var fileInput = document.getElementById('Acceptance_doc_path').value();
		 alert(fileInput);
		 return false;
		 file= fileInput.files[0];
		alert(contract_id)
		alert(fileInput + "fileInput")
		alert("file" + file)
		
		$.ajax({
			type:"POST",
			url:"s.obj",
			data:{"contract_id":contract_id,
				    "file": file,
				
				},
			     success:function(result){
				
 				   var data= jQuery.parseJSON(result);
 				   alert(data +"data")
 				  
 			
 				  
			}	
			
		});
		
		 
		 window.location.reload();
	}
	</script>   -->
<!-- <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
    function updatemillacceptflag(contract_id) {
    	alert(contract_id)
        var fileInput = document.getElementById('Acceptance_doc_path');
        var file = fileInput.files[0];  // Get the selected file

        var formData = new FormData();
        formData.append('contract_id', contract_id);
        formData.append('Acceptance_doc_path', file);
        alert( formData.append('Acceptance_doc_path', file)  +"formdata")
        alert(file +"file")
        $.ajax({
            type: "POST",
            url: "s.obj",
            data: formData,
          /*   contentType: false, */
            processData: false,
            success: function (result) {
                var data = jQuery.parseJSON(result);
                alert("MMMMM")
                alert(data);
       window.location.reload();             },
            error : function(err) {

				// Handle errors here

				console.error('AJAX request failed: ', err);

				alert("errorrrrrrrrrrr")

			}
        	
        });

    }
</script>
 -->

<!--   <script>
	function upload(contract_id){
		alert(contract_id)
		var fileInput = document.getElementById('Acceptance_doc_path');
		alert(fileInput + "fileInpu")
		var inputvalue = fileInput.value;
		alert(inputvalue + "inputvalue")
		  var file = fileInput.files[0];  // Get the selected file
           alert(file+ "file")
	        var formData = new FormData();
	        formData.append('contract_id', contract_id);
	        formData.append('Acceptance_doc_path', file);
	        alert(formData.get('Acceptance_doc_path'))
		
		alert(inputvalue)
		 $.ajax({
	            type: "POST",
	            url: "r.obj",
	            data: formData,
	            contentType: false,
	            processData: false,
	           
	            success: function (result) {
	                var data1 = jQuery.parseJSON(result);
	                alert("MMMMM");
	                alert(data1);
	                window.location.reload();
	            },
	            error: function (err) {
	                // Handle errors here
	                console.error('AJAX request failed: ', err);
	                alert("errorrrrrrrrrrr");
	            }
	           
	        });
		
	}
	</script> 
 -->

</head>

<body class="fixed-navbar">
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
				<h1 class="page-title">Mill Acceptance List</h1>

			</div>


			<div class="page-content fade-in-up">
				<div class="ibox">
					<span>${msg}</span>
					<div class="ibox-body">
						<div class="scrollmenu">
							<table
								class="table table-striped table-bordered table-hover tableFixHead"
								id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>

										<th>Contract No.</th>
										<th>Contract Date</th>
										<th>Quantity</th>
										<th>Contract Value Online</th>
										<th>Contract Value LC</th>
										<th>Payment Due Date</th>
										<th>Upload Signed Doc</th>
										<th>Action</th>





									</tr>
								</thead>
								<tbody>

									<c:forEach items="${AllList}" var="item">


										<tr>

											<td>${item.getContract_no()}</td>
											<td>${item.getContract_date()}</td>
											<td>${item.getContract_qty()}</td>
											<td>${item.getContract_value()}</td>
											<td>${item. getPayment_duedate()}</td>

											 <form action="savemill.obj" enctype="multipart/form-data" method="POST">
											<td>
											<input type="file" name="Acceptance_doc_path"
													id="Acceptance_doc_path">
								<input type="hidden" id="contract_id" name="contract_id" value="${item.contract_id}">
													</td>
												<td>
													<c:choose>
														<c:when test="${item.contract_acceptance_flag eq '0'}">
												<button class = "btn btn-danger" type="submit">Accept</button>
												</c:when>
												<c:otherwise>
												<button class= "btn btn-success">Accepted</button>
												</c:otherwise>
												</c:choose>
												</td>
												

											</form>
											


										</tr>
									</c:forEach>
								









								</tbody>

							</table>
						</div>
					</div>
				</div>

			</div>
			<!-- END PAGE CONTENT-->
			<%@ include file="footer.jsp"%>
		</div>
	</div>
	<!-- BEGIN THEME CONFIG PANEL-->

	<!-- END THEME CONFIG PANEL-->
	<!-- BEGIN PAGA BACKDROPS-->
	<div class="sidenav-backdrop backdrop"></div>

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
	<script src="./assets/vendors/DataTables/datatables.min.js"
		type="text/javascript"></script>
	<!-- CORE SCRIPTS-->
	<script src="assets/js/app.min.js" type="text/javascript"></script>
	<!-- PAGE LEVEL SCRIPTS-->
	<script type="text/javascript">
		$(function() {
			$('#example-table').DataTable({

				fixedHeader : true

			//"ajax": './assets/demo/data/table_data.json',
			/*"columns": [
			    { "S": "name" },
			    { "data": "office" },
			    { "data": "extn" },
			    { "data": "start_date" },
			    { "data": "salary" }
			] */
			});
		})
	</script>
	
	 <script>
	function upload(contract_id){
		alert(contract_id)
		var fileInput = document.getElementById('Acceptance_doc_path' + contract_id);
		if(fileInput != "")
			{
			  var file = fileInput.files[0];  // Get the selected file
			}
		else
			{
			file = "null";
			}
		alert("file"+file)       
	        var formData = new FormData();
	        formData.append('contract_id', contract_id);
	        formData.append('Acceptance_doc_path', file);
	       // alert(formData.get('Acceptance_doc_path') + " get")
		
		alert(inputvalue)
		 $.ajax({
	            type: "POST",
	            url: "savemill.obj",
	            data: formData,
	            contentType: false,
	            processData: false,
	           
	            success: function (result) {
	                var data1 = jQuery.parseJSON(result);
	                alert("MMMMM");
	                alert(data1);
	               
	            },
	            error: function (err) {
	                // Handle errors here
	                console.error('AJAX request failed: ', err);
	                alert("errorrrrrrrrrrr");
	            }
	           
	        });
	        window.location.reload();
		
	}
	
	
	</script>
	<!-- <script>
<!-- function upload(contract_id){
    alert(contract_id);

    var fileInput = document.getElementById('Acceptance_doc_path' + contract_id).value;
    alert("ddddddddd"+ fileInput)
    //var k =  fileInput.files[0]
   // alert(k +"eee")
   //return false;
    var formData = new FormData();
    formData.append('contract_id', contract_id);

    // Check if a file is selected
    if (fileInput != "") {
        var file = fileInput.files[0];
        formData.append('Acceptance_doc_path', file);
    } else 
    
        // Handle the case where no file is selected
        formData.append('Acceptance_doc_path', null);
    }

    $.ajax({
        type: "POST",
        url: "savemill.obj",
        data: formData,
        contentType: false,
        processData: false,
        success: function (result) {
            var data1 = jQuery.parseJSON(result);
            alert("MMMMM");
            alert(data1);
        },
        error: function (err) {
            // Handle errors here
            console.error('AJAX request failed: ', err);
            alert("errorrrrrrrrrrr");
        }
    });

    window.location.reload();
}
</script> --> -->
	
	<!-- <script>
function upload(contract_id){
    alert(contract_id);
    alert(document.getElementById('Acceptance_doc_path') +"idd")
    var check =document.getElementById('Acceptance_doc_path')
  if( check != null){
    var fileInput = document.getElementById('Acceptance_doc_path' + contract_id);
    var file = fileInput.files[0];  // Get the selected file
    var formData = new FormData();
    formData.append('contract_id', contract_id);
    formData.append('Acceptance_doc_path', file);
  }else{
	  formData.append('contract_id', contract_id);
	  formData.append('Acceptance_doc_path', null);
  }
    // Check if a file is selected
   

    $.ajax({
        type: "POST",
        url: "savemill.obj",
        data: formData,
        contentType: false,
        processData: false,
        success: function (result) {
            var data1 = jQuery.parseJSON(result);
            alert("MMMMM");
            alert(data1);
        },
        error: function (err) {
            // Handle errors here
            console.error('AJAX request failed: ', err);
            alert("errorrrrrrrrrrr");
        }
    });

    window.location.reload();
}

</script> -->
	
<!-- 
	 <script>
	function upload(contract_id){
		alert(contract_id)
		var fileInput = document.getElementById('Acceptance_doc_path' + contract_id);		
		var inputvalue = fileInput.value;
		alert(inputvalue + "inputvalue")
		 var file = fileInput.files[0];  // Get the selected file
		alert("file"+file)
          
	        var formData = new FormData();
	        formData.append('contract_id', contract_id);
	        formData.append('Acceptance_doc_path', file);
	        alert(formData.get('Acceptance_doc_path') + "get")
		
		alert(inputvalue)
		 $.ajax({
	            type: "POST",
	            url: "savemill.obj",
	            data: formData,
	            contentType: false,
	            processData: false,
	           
	            success: function (result) {
	                var data1 = jQuery.parseJSON(result);
	                alert("MMMMM");
	                alert(data1);
	               
	            },
	            error: function (err) {
	                // Handle errors here
	                console.error('AJAX request failed: ', err);
	                alert("errorrrrrrrrrrr");
	            }
	           
	        });
	        window.location.reload();
		
	}
	
	
	</script> -->

 


</body>

</html>

