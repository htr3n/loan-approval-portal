<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Staff Login</title>

    <%@ include file="../parts/header_css.html" %>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>

</head>
<body>
<c:import url="message.jsp"/>
<div id="content">
    <form:form id="loginForm" method="post" modelAttribute="staffLoginForm">
        <form:hidden path="action" id="action"/>
        <div id="heading"></div>
        <div id="title"><img id="imgLock" src="../images/lock.png" alt=""/>
            Log in the Staff Portal
        </div>
        <div id="formBody">
            <label for="id">Staff:</label>
            <form:select path="id" id="id" onchange="submitForm('changed');">
                <form:option value="" label=""/>
                <c:forEach items="${staffs}" var="staff">
                    <form:option value="${staff.staffId}" label="${staff.firstName} ${staff.lastName}"/>
                </c:forEach>
            </form:select>
            <form:errors cssClass="loginError" path="id"/>

            <label for="password">Password:</label>
            <form:password path="password"/>&nbsp;&nbsp;
            <form:errors cssClass="loginError" path="password"/>

            <label for="staffRole">Role<span class="required">*</span></label>
            <form:select path="staffRole" id="staffRole">
                <form:option value="" label=""/>
                <c:forEach items="${roles}" var="role">
                    <form:option value="${role.roleName}" label="${role.roleName}"/>
                </c:forEach>
            </form:select>
            <form:errors cssClass="loginError" path="staffRole"/>
            <div id="divSubmit">
                <div class="buttons">
                    <a onclick="submitForm('');"><img src="../images/login.png" alt=""/>Log In</a>
                </div>
            </div>
        </div>
    </form:form>
</div>
<%@ include file="../parts/footer_scripts.html" %>
<script type="text/javascript">
    <!--
    function submitForm(action) {
        $("#action").val(action);
        $('#loginForm').submit();
    }

    //-->
</script>
<c:import url="doc-ready.jsp"/>

</body>
</html>