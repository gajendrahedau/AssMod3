<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title> Registration </title>
<style>
.error{
	color: blue;
	font-weight: bold;
}
</style>
</head>
<body>
<div align="center">
<h2>Enroll Associate Details Here</h2>
<table>

<form:form action="registerAssociate" method="post" modelAttribute="associate">

<tr>
<td>FirstName</td>
<td><form:input path="firstName" size="30"/></td>
<td><form:errors path="firstName" cssClass="error"/></td>
</tr>

<tr>
<td>LastName</td>
<td><form:input path="lastName" size="30"/></td>
<td><form:errors path="lastName" cssClass="error"/></td>
</tr>

<tr>
<td>Department</td>
<td><form:input path="department" size="30"/></td>
<td><form:errors path="department" cssClass="error"/></td>
</tr>

<tr>
<td>EmailID</td>
<td><form:input path="emailId" size="30"/></td>
<td><form:errors path="emailId" cssClass="error"/></td>
</tr>

<tr>
<td>Designation</td>
<td><form:input path="designation" size="30"/></td>
<td><form:errors path="designation" cssClass="error"/></td>
</tr>

<tr>
<td>Pancard</td>
<td><form:input path="pancard" size="30"/></td>
<td><form:errors path="pancard" cssClass="error"/></td>
</tr>

<tr>
<td>BankName</td>
<td><form:input path="bankdetails.bankName" size="30"/></td>
<td><form:errors path="bankdetails.bankName" cssClass="error"/></td>
</tr>

<tr>
<td>ifscCode</td>
<td><form:input path="bankdetails.ifscCode" size="30"/></td>
<td><form:errors path="bankdetails.ifscCode" cssClass="error"/></td>
</tr>

<tr>
<td>accountNumber</td>
<td><form:input path="bankdetails.accountNumber" size="30"/></td>
<td><form:errors path="bankdetails.accountNumber" cssClass="error"/></td>
</tr>

<tr>
<td>Epf</td>
<td><form:input path="salary.epf" size="30"/></td>
<td><form:errors path="salary.epf" cssClass="error"/></td>
</tr>

<tr>
<td>Company PF</td>
<td><form:input path="salary.companyPf" size="30"/></td>
<td><form:errors path="salary.companyPf" cssClass="error"/></td>
</tr>

<tr>
<td><input type="submit" value="Submit"></td>
</tr>

</form:form>

</table>

</div>
</body>
</html>