<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="success.lti">
<div>

name:<input type="text" name="name" value="${applicant.name}" readonly><br>
age: <input type="number" name="age" value="${applicant.age }" readonly><br>
<c:choose>
	<c:when test="${applicant.gender.equals('m') }">
	gender:male <input type="radio"  name="gender" value="m" checked readonly><br>
	</c:when>
	<c:otherwise>
	gender:female <input type="radio"  name="gender" value="f" checked readonly><br>
	</c:otherwise>
</c:choose> 
contact number: <input type="number" name="mobile" value="${applicant.mobile}" readonly><br>
email: <input type="text" name="email" value="${applicant.email }" readonly><br>
password: <input type="text" name="password"><br>
yearly salary: <input type="number" name="ysal" value="${applicant.ysal }" readonly ><br>
<c:choose>
	<c:when test="${applicant.eEmi.equals('yes') }">
existing emis:Yes <input type="radio" onclick="check();" id="yes" name="eEmi" value="yes" checked readonly>
	</c:when>
	<c:otherwise>
existing emis:No <input type="radio" onclick="check();" id="no" name="eEmi" value="no" checked readonly><br>
	</c:otherwise>
</c:choose>
<div class="reveal-if-active"  id="yescheck" style="visibility:hidden">
  emi amount:<input type="number" name="eamount" ><br>
  emi paid:<input type="number" name="paid" ><br>
  tenure of emi:<input type="number" name="tenure" ><br>
</div>
</div>
car make:<select name="cmake"  readonly>
<c:forEach items="${make }" var="item">
<option value="${item}">${item}</option>
</c:forEach>
</select>
car model:<input type="text" name="cmodel" value="${vehicle.cmodel }" readonly ><br>
ex-showroom price:<input type="text" name="exprice" value="${vehicle.exprice }"  readonly><br>
Amount<input type="number" name="lamount" value="${loan.lamount }" readonly>
<br>Tenure<input type="number" name="ltenure" value="${loan.ltenure }" readonly>
<br>ROI<input type="number" name="lroi" value="${loan.lroi }" readonly>
<br>EMI<input type="number"  name="lemi" value="${loan.lemi }" readonly>

 <select name="type">
<option value="salaried">Salaried</option>
</select> 
<input type="number" name="monthlySal" value="${empDetails.monthlySal}" readonly>
<input type="number"  name="rentalIncome"value="${empDetails.rentalIncome }" readonly>
<input type="text" name="employerName" value="${empDetails.employerName }" readonly>

<input type ="submit" value="Apply">
</form>
</body>
</html>