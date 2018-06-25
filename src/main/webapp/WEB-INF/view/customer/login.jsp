<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
   <meta http-equiv="Pragma" content="no-cache">
   <meta http-equiv="Expires" content="0">
   <meta http-equiv="Cache-Control" content="no-cache">
    <title>Login</title>
    <%@ include file="../parts/header_css.html" %>
    <link rel="stylesheet" type="text/css" href="css/login.css" />
</head>
<body>
  <c:import url="tab.jsp"/>
  <c:import url="message.jsp" />
  <form:form id="loginForm" method="post" modelAttribute="loginForm">
    <div id="content">
		   <div id="formBody"> 
				<label for="email">Email</label> 
				<form:input path="email"/>&nbsp;&nbsp;<form:errors cssClass="loginError" path="email" />
				<label for="pin">PIN</label>
				<form:password path="pin" />&nbsp;&nbsp;<form:errors cssClass="loginError" path="pin" />				
		      <div id="divSubmit">
		        <div class="buttons">
		          <a onclick="$('#loginForm').submit();"><img src="images/login.png" alt=""/>Log In</a>
		        </div>
		      </div>	            
	      </div>
    </div>
	</form:form>

  <%@ include file="../parts/footer_scripts.html" %>

  <c:import url="doc-ready.jsp"/>
</body>
</html>