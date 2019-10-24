<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="obj" class="com.gladiator.entity.Applicant"/>
<%@ page import="com.gladiator.entity.Applicant" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="properties.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
<form action="emiSche.lti">
MAX AMOUNT <br>
<br><br>TENURE <br>

<div class="slidecontainer">
    <p>Loan Amount: <input type="number" id="loanAmount" min="50000" max="${maxLoanAmount}" value="${maxLoanAmount}" oninput="check()" name="lamount" ></p>
  <input type="range" min="50000" max="${maxLoanAmount}" value="${maxLoanAmount}" class="slider" id="myRange1" >
  <span id="vleft">&#8377; 50000</span><span id="vright">&#8377;${maxLoanAmount}</span>   
</div>

<div class="slidecontainer">
    <p>Tenure: <input type="number" id="loanTenure" name="ltenure"  min="6" max=" ${maxTenure}" value="${maxTenure}"></p>
  <input type="range" min="6" max="${maxTenure}" value="${maxTenure}" class="slider" id="myRange2" >
  <span id="vleft">&#8377; 50000</span><span id="vright">&#8377;${maxTenure}</span>   
</div>


<br>ROI<input type="number" name="lroi" id="lroi" value="10"  readonly>
<br>EMI<input type="text"  name="lemi"  id="emi" value="${calcEmi}"  readonly>
<br><input type="submit" value="Emi Scheduler">


</form>
<a href="regisfinal.lti"><button >Apply</button></a>
</form>
</body>
<script>
var aSlider = document.getElementById("myRange1");
var aInput = document.getElementById("loanAmount");
var lRoi=document.getElementById("lroi");
var tSlider = document.getElementById("myRange2");
var tInput = document.getElementById("loanTenure");
var rEmi = document.getElementById("emi");
tInput .value = tSlider.value;
aInput.value = aSlider.value;

aSlider.oninput = function() {
	aInput.value = this.value;
	  $.ajax({
          url: "emi.lti",
          data: {"lAmount" :$("#myRange1").val()   ,"lTenure":$("#myRange2").val() },
          success: function(data){
          	$("#emi").val(data);
          },
          error:function(){
              alert("error");
          }

      });
} 

aInput.oninput = function() {
	 aSlider.value = this.value;
	
	}

tSlider.oninput = function() {
	tInput .value = this.value;
	$.ajax({
        url: "emi.lti",
        data: {"lAmount" :$("#myRange1").val()   ,"lTenure":$("#myRange2").val() },
        success: function(data){
        	$("#emi").val(data);
        },
        error:function(){
            alert("error");
        }

    });
}
tInput .oninput = function() {
	tSlider.value = this.value;
}
</script> 
</html>