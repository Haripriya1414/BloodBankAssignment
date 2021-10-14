<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Camp Registration</title>
<style>

fieldset{
background-color: #f1f1f1;
border: none;
border-radius: 2px;
margin-bottom: 12px;
overflow: hidden;
padding: 0 .625em;
}

label{
cursor: pointer;
display: inline-block;
padding: 3px 6px;
text-align: right;
width: 250px;
vertical-align: top;
}

input{
font-size: inherit;
}

h1{
color:red

}
div
{
text-align: justify;
}

</style>
</head>
<body>
<div>
<form:form action="/addCamp" modelAttribute="camp" method="post">
<div>
<label for="">Camp Id</label>
<form:input path="campId"/>
<form:errors path = "campId" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">Camp Name</label>
<form:input path="campName"/>
<form:errors path = "campName" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">Camp Location</label>
<form:input path="campLocation"/>
<form:errors path = "campLocation" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">Camp Date</label>
<form:input type="date" path="campDate"/>
<form:errors path = "campDate" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">Camp Contact Number</label>
<form:input path="campPhoneNumber"/>
</div>
<br>
<div>
<label for="">Location Pincode</label>
<form:input path="campPincode"/>
</div>
<br>
<div>
<input type ="submit" value="Register">
</div>
</form:form>
</div>
</body>
</html>