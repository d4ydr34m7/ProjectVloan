<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<form action="cardet.lti">
<div>
name:<input type="text" name="name" ><br>
age: <input type="number" name="age" ><br>
gender:male <input type="radio"  name="gender" value="m"><br>
female <input type="radio"  name="gender" value="f"><br>
contact number: <input type="number" name="mobile"><br>
email: <input type="text" name="email"><br>
yearly salary: <input type="number" name="ysal" ><br>
existing emis:Yes <input type="radio" onclick="check();" id="yes" name="ee" value="yes">
         No <input type="radio" onclick="check();" id="no" name="eEmi" value="no"><br>
         


<div class="reveal-if-active"  id="yescheck" style="visibility:hidden">
  emi amount:<input type="number" name="eamount" ><br>
  emi paid:<input type="number" name="paid" ><br>
  tenure of emi:<input type="number" name="tenure" ><br>
</div>
</div>
car make:<select name="cmake" class="carMake" >
<c:forEach items="${make }" var="item">

<option value="${item}">${item}</option>
</c:forEach>
</select>
car model:<select name="cmake" class="carModel"  id="model"></select><br>
ex-showroom price:<input type="text" name="exprice" class="exprice"><br>
<input type ="submit" value="next">

 <select name="type">
<option value="salaried">Salaried</option>
</select> 
<input type="number" name="monthlySal">
<input type="number"  name="rentalIncome">
<input type="text" name="employerName">

</form>
<div class="output"></div>
<script>
$(document).ready(function(){
	  $(".carMake").change(function(){
		  
		  $.ajax({
	            url: "model.lti",
	            data: {"cMake" : $(".carMake").val()},
	            success: function(data){
	            	model= data.split("[");
	            	model=model[1];
	            	model=model.split("]");
	            	model=model[0].split(",");
	            	$(".output").html(data);
	              var slctSubcat=$('#model'), option="";
	                slctSubcat.empty();
	                for(var i=0; i<model.length; i++){
	                    option = option + "<option value='"+model[i] + "'>"+model[i] + "</option>";
	                }
	                slctSubcat.append(option); 
	            },
	            error:function(){
	                alert("error");
	            }

	        });
	  });
	  
	  $(".carModel").change(function(){
		  alert("dd");
		  $.ajax({
	            url: "carPrice.lti",
	            data: {"cMake" : $(".carMake").val(),"cModel":$(".carModel").val()},
	            success: function(data){
	            	model= data.split(",");
	            	$(".exprice").val(data);
	            },
	            error:function(){
	                alert("error");
	            }

	        });
	  });
});
function check() {
    if (document.getElementById('yes').checked) {
        document.getElementById('yescheck').style.visibility = 'visible';
    }
    else document.getElementById('yescheck').style.visibility = 'hidden';

}

</script>



</body>
</html>