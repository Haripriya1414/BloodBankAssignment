<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Donors</title>
<style type="text/css">

table {
width: 100%;
border: 1px solid #000;
}

th, td {
width: 25%;
text-align: left;
vertical-align: top;
border: 1px solid #000;
border-collapse: collapse;
padding: 0.3em;
caption-side: bottom;
}

caption {
padding: 0.3em;
color: #fff;
background: #000;
}



th {
background: #eee;
}

</style>
</head>
<body>
<table>
<tr>
<th>Donor Id</th>
<th>Donor Name</th>
<th>Donor Blood Group</th>
<th>Age</th>
<th>Location</th>
<th>Phone Number</th>
<th>Last Donation Date</th>
<th>PinCode</th>
</tr>
<c:forEach items ="${donors}" var ="eachItem">
<tr>
<td>${eachItem.donorId}</td>
<td>${eachItem.donorName}</td>
<td>${eachItem.bloodGroup}</td>
<td>${eachItem.age}</td>
<td>${eachItem.location}</td>
<td>${eachItem.phoneNumber}</td>
<td>${eachItem.lastDonation}</td>
<td>${eachItem.pincode}</td>
</tr>
</c:forEach>
</table>
</body>
</html>