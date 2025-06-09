<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Football league platform!</title>
</head>
<body>


<form:form action="/userlogin" method="post" modelAttribute="userLogin">
<form:label path="username">Username:</form:label>
<form:input path="username" />


<form:label path="password">Password:</form:label>
<form:input path="password" type="password"/>



<input type="submit" value="Apply" />

<h3>Summary:</h3>

	<form:errors path="username"/>
	<br>
	<form:errors path="password"/>
	<br>
	
</form:form>

<br>
<br>

<form:form action="/usersignup" method="post" modelAttribute="userSignup">
	<form:label path="username">Username:</form:label>
	<form:input path="username"/>
	
	<form:label path="password">password:</form:label>
	<form:input path="password" type="password"/>
	
	<form:label path="confirmPassword">confirm password : </form:label>
	<form:input path="confirmPassword" type="password"/>
	
	<form:label path="phonenumber">phonenumber:</form:label>
	<form:input path="phonenumber"/>
	
	<form:label path="email">email:</form:label>
	<form:input path="email"/>
	
	<form:label path="address">address:</form:label>
	<form:input path="address"/>
	
	<input type="submit" value="Apply!" />
	
	<h3>Summary:</h3>

	<form:errors path="username"/>
	<br>
	<form:errors path="password"/>
	<br>
	<form:errors path="phonenumber"/>
	<br>
	<form:errors path="email"/>
	<br>
	<form:errors path="address"/>
	<br>
	<form:errors path="confirmPassword"/>
</form:form>


</body>
</html>