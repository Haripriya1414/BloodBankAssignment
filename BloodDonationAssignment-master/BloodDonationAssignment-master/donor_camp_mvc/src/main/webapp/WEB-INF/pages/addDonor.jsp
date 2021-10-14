 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor Registration</title>
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
<form:form action="/addDonor" modelAttribute="donor" method="post">
<div>
<label for="">Donor Id</label>
<form:input path="donorId"/>
<form:errors path = "donorId" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">Donor Name</label>
<form:input path="donorName"/>
<form:errors path = "donorName" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">Donor Blood Group</label>
<form:input path="bloodGroup"/>
<form:errors path = "bloodGroup" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">Donor Age</label>
<form:input path="age"/>
<form:errors path = "age" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">Location</label>
<form:input path="location"/>
<form:errors path = "location" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">Phone Number</label>
<form:input path="phoneNumber"/>
<form:errors path = "phoneNumber" cssStyle="color:red"/>
</div>
<br>
<div>
<label for="">LastDonation</label>
<form:input type="date" path="lastDonation"/>
</div>
<br>
<div>
<label for="">Pincode</label>
<form:input  path="pincode"/>
<form:errors path = "pincode" cssStyle="color:red"/>
</div>
<br>
<div>
<input type ="submit" value="Register">
</div>
</form:form>
</div>
</body>
</html>