<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.jci.model.ZoneModel"%>
<%@page import="com.jci.model.VerifyFarmerModel"%>
<%@page import="com.jci.model.FarmerRegModelDTO"%>
<%@page import="com.jci.model.StateList"%>
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
    <link href="./assets/vendors/DataTables/datatables.min.css" rel="stylesheet" />
    <!-- THEME STYLES-->
    <link href="assets/css/main.min.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES-->
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>

 <script src="https://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>  
 <script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js" type="text/javascript"></script>  
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />  
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <script type="text/javascript">
	$(document).ready(function ()  
	{  
		 $("#farmerVerific").DataTable({         
	         scrollX: true,
	         "pageLength": 50
	       }); 
	});  
 </script>  
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
                <h1 class="page-title">Farmer List</h1>
            </div>
			
			
			<div class="row">
				
										
										
										
										<!-- <div>
										<label> </label> &nbsp;&nbsp;&nbsp; 
										<input type = "submit" id="search" value ="search" class="btn btn-primary" style ="display: block;">

										</div> -->
									
			</div>
			
                   <div class="table-responsive" style="margin-top: 20px;">                    
                        <table id="farmerVerific"
					class="table table-striped table-bordered table-hover"
					cellspacing="0">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Contract No.</th>

							<th>Allowed Quantity</th>
							<th>Regional Office</th>



							<th>Last date of Shipment</th>

							<th>DI No</th>



							<th>DI Date</th>

							<th>Jute Variety</th>


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
						<%
						int i = 1;
						%>
						<c:forEach items="${AllList}" var="item">

							<tr>
								<td class="sorting_1" style="text-align: center"><%=i%></td>
								<td style="text-align: center">${item.getContract_No()}</td>

								<td style="text-align: center">${item.getAllowed_qty()}</td>
								<td style="text-align: center">${item.getRegional_office()}</td>


								<td style="text-align: center">${item. getLast_date_of_Shipment() }</td>
								<td style="text-align: center">${item.getDI_no()}</td>
								<td style="text-align: center">${item.getDI_Date()}</td>

								<td style="text-align: center">${item.getJute_variety()}</td>

								<td style="text-align: center">${item.getGr1_qty() }</td>
								<td style="text-align: center">${item.getGr2_qty() }</td>

								<td style="text-align: center">${item.getGr3_qty() }</td>
								<td style="text-align: center">${item.getGr4_qty() }</td>
								<td style="text-align: center">${item.getGr5_qty() }</td>
								<td style="text-align: center">${item.getGr6_qty() }</td>
								<td style="text-align: center">${item.getGr7_qty() }</td>
								<td style="text-align: center">${item.getGr8_qty() }</td>


							</tr>
							<%
							i++;
							%>
						</c:forEach>

					</tbody>
				</table>

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
   
    
   

	


</body>

</html>
