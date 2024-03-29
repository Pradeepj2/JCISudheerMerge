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
    <link href="./assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="./assets/vendors/themify-icons/css/themify-icons.css" rel="stylesheet" />
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- PLUGINS STYLES-->
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
     <script type="text/javascript">
	$(document).ready(function ()  
	{  
		 $("#farmerVerific").DataTable({         
	         scrollX: true,
	         "pageLength": 50
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
.tableFixHead          { overflow: auto; height: 100px; width: 240px; }
.tableFixHead thead th { position: sticky; top: 0; z-index: 1; }
.tableFixHead tbody th { position: sticky; left: 0; }
table  { border-collapse: collapse; width: 100%; }
th, td { padding: 8px 16px; white-space: nowrap; }
th     { background:#eee; }
</style>
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
                <h1 class="page-title">View Dispatch Ho List</h1>
                 
            </div>
				
					
			 <div class="page-content fade-in-up">
                <div class="ibox">
                    <span>${msg}</span>
                    <div class="ibox-body">
                    <div class="scrollmenu">
                         <table class="table table-striped table-bordered table-hover tableFixHead" id="example-table" cellspacing="0" width="100%">


								<thead>
									<tr>
										<th>Contract No.</th>
										<th>Contract Date</th>
										 <th>Crop year</th>
										 <th>FC Ref No</th>
										 <th>Contracted Qty</th> 										
										<th>Allowed Qty</th>
										<th>Regional Office</th>
										  <th>DPC</th> 
										
									    
										<th>Last date of Shipment</th> 
																				
										<th>DI No</th>
									  
										
									   
										<th>DI Date</th> 										
										
										<th>Jute Variety</th>
										<th>Remarks</th>
										<!-- <th>Grade Wise Allocation</th> -->
										<th>Grade-1</th>
										<th>Grade-2</th>
										<th>Grade-3</th>
										<th>Grade-4</th>
										<th>Grade-5</th>
										<th>Grade-6</th>
										<th>Grade-7</th>
										<th>Grade-8</th>
										
										
							</tr>
								</thead>
								<tbody>
						
							      <c:forEach items="${AllList}" var="item">
									<tr>
									
								<td> ${item.getContract_No()}</td>
							    <td> ${item.getContract_Date()} 
								<td>  ${item.getCrop_year()}</td>
								<td>  ${item.getFC_Ref_No()}</td>
								<td>  ${item.getContracted_Qty()}</td>
								<td>  ${item.getAllowed_qty()}</td>
								<td>  ${item.getRegional_office()}</td>
								<td>  ${item.getDPC()}</td>

								<td>  ${item. getLast_date_of_Shipment() }</td>
									<td>  ${item.getDI_no()}</td>
								<td>  ${item.getDI_Date()}</td>
								
								<td>  ${item.getJute_variety()}</td>
									<td>  ${item.getRemarks() }</td>
									<td>  ${item.getGr1_qty() }</td>
									<td>  ${item.getGr2_qty() }</td>
									<td>  ${item.getGr2_qty() }</td>
									<td>  ${item.getGr3_qty() }</td>
									<td>  ${item.getGr4_qty() }</td>
									<td>  ${item.getGr5_qty() }</td>
									<td>  ${item.getGr6_qty() }</td>
									<td>  ${item.getGr7_qty() }</td>
									<td>  ${item.getGr8_qty() }</td>

						
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
    <script src="./assets/vendors/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/popper.js/dist/umd/popper.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/metisMenu/dist/metisMenu.min.js" type="text/javascript"></script>
    <script src="./assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL PLUGINS-->
    <script src="./assets/vendors/DataTables/datatables.min.js" type="text/javascript"></script>
    <!-- CORE SCRIPTS-->
    <script src="assets/js/app.min.js" type="text/javascript"></script>
    <!-- PAGE LEVEL SCRIPTS-->
    <script type="text/javascript">
        $(function() {
            $('#example-table').DataTable({
            	
            	    fixedHeader: true
            
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
    
</body>

</html>