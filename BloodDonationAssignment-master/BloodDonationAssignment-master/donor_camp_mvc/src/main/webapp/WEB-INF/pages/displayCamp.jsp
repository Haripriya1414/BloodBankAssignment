<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Camp Details</title>
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
<th>Camp Id</th>
<th>Camp Name</th>
<th>Location</th>
<th>Date</th>
<th>Contact Number</th>
<th>PinCode</th>
</tr>
<c:forEach items ="${camp}" var ="eachItem">
<tr>
<td>${eachItem.campId}</td>
<td>${eachItem.campName}</td>
<td>${eachItem.campLocation}</td>
<td>${eachItem.campDate}</td>
<td>${eachItem.campPhoneNumber}</td>
<td>${eachItem.campPincode}</td>
</tr>
</c:forEach>
</table>
</body>
</html>