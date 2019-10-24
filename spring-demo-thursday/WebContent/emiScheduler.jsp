<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>

<td>Month #</td><td>Month</td><td>Loan Balance</td><td>Emi</td><td>Monthly interest</td><td>Principal repaid</td><td>Outstanding Loan Amount</td></tr>
<%
int loanBalance=Integer.parseInt(request.getParameter("lamount"));
System.out.println(loanBalance);
System.out.println(request.getParameter("ltenure"));
for(int i=1;i <=Integer.parseInt(request.getParameter("ltenure"));i++){ 
	int monthlyInterest=(int)(((double)loanBalance*(((double)Integer.parseInt(request.getParameter("lroi"))/(double)1200))));
	int principalRepay=Integer.parseInt(request.getParameter("lemi"))-monthlyInterest;
	
	out.print("<tr><td>"+(i)+"</td><td>month</td>");
	out.print("<td>"+loanBalance+"</td>");
	out.print("<td>"+Integer.parseInt(request.getParameter("lemi"))+"</td>");
	out.print("<td>"+monthlyInterest+"</td>");
	out.print("<td>"+principalRepay+"</td>");
	loanBalance=loanBalance-principalRepay;
	if(loanBalance<0){
		loanBalance=0;
	}
	out.print("<td>"+loanBalance+"</td></tr>");
}%>


</table>
</body>
</html>