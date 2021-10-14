<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BLOOD CAMP</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>

table {
width: 100%;
border: 1px solid #000;
position: relative;
align-items: center;
}

th, td {
width: 10%;
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


</style>
</head>
<body>
<h1 style="text-align: center; font-family: monospace;">${majHeading}</h1>
<hr>
<table>
<tr>
<th><a href="/addDonor"><button class="btn-btn-primary">Register For Donor</button></a></th>
<th><a href="/getAllDonors"><button class="btn-btn-primary">Display All Donors</button></a></th>
<th><a href="/addCamp"><button class="btn-btn-primary">Register For Camp</button></a></th>
<th><a href="/getAllCamp"><button class="btn-btn-primary">Display The Camp Details</button></a></th>
</tr>
</table>
<br>
<br>
<table>
<tr>
<th>
<form action="/getBloodGroup" >
<label for="">Search By Blood Group</label>
<input type="text" name="search">
<input type="submit"></form>
</th>
<th>
<form action="/getLocation" >
<label for="">Search By Location</label>
<input type="text" name="location">
<input type="submit"></form>
</th>
<th>
<form action="/unregister" >
<label for="">UnRegister</label>
<input type="text" name="value">
<input type="submit"></form>
</th>
</tr>
</table>
<br>
<br>
<div>
<h3><b>Update donor's details</b></h3>
<br>
<br>
<form action="/updatedonor" >
<label for="">Donor Id</label>
<input type="number" name="donorId">
<br>
<br>
<label for="">Donor Name</label>
<input type="text" name="donorName">
<br>
<br>
<label for="">Blood Group</label>
<input type="text" name="bloodGroup">
<br>
<br>
<label for="">Age</label>
<input type="number" name="ageno">
<br>
<br>
<label for="">Donor Location</label>
<input type="text" name="donorLocation">
<br>
<br>
<label for="">Phone Number</label>
<input type="number" name="num">
<br>
<br>
<label for="">Last Donation date</label>
<input type="date" name="preDate">
<br>
<br>
<label for="">Pincode</label>
<input type="number" name="pinCode">
<br>
<br>
<input type="submit" >
</form>
</div>


<hr>
<div>
<h3><b>Update Camp details</b></h3>
<br>
<br>
<form action="/updateCamp" >
<label for="">Camp Id</label>
<input type="number" name="id">
<br>
<br>
<label for="">Camp Name</label>
<input type="text" name="name">
<br>
<br>
<label for="">Location</label>
<input type="text" name="location">
<br>
<br>
<label for="">Date</label>
<input type="date" name="date">
<br>
<br>
<label for="">Contact Number</label>
<input type="number" name="num">
<br>
<br>
<label for="">Pincode</label>
<input type="number" name="pin">
<br>
<br>
<input type="submit" class="btn-btn-primary">
</form>
</div>
<br>
<br>
<table>
<tr>
<th>
<form action="/getByCampLocation" >
<label for="">Search By Location for camp</label>
<input type="text" name="camplocation">
<input type="submit"></form>
</th>
<th>
<form action="/unregisterCamp" >
<label for="">UnRegister</label>
<input type="text" name="unregister">
<input type="submit"></form>
</th>
</tr>
</table>
<br>
<br>
<h1 style="text-align: center;color: red; font-family: monospace;">Blood Donation Is A Great Act Of Kindness</h1>
</body>
</html>