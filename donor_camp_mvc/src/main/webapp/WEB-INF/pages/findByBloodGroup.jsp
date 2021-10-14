<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Search for Donors by blood group</h2>
<h2>Donors List</h2>
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