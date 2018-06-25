<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>WestBank Portal</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Cache-Control" content="no-cache">
    <%@ include file="../parts/header_css.html" %>
</head>
<body>

<c:import url="tab.jsp"/>

<div id="content">
    <div class="text">
        <span class="heading">For Loan Approval in an Instant</span>
    </div>
    <div class="text">WestBank is proud to bring you the fastest
        online approval. A part of the Na'vi United Corp., WestBank
        provides mortgage loan for lenders throughout the Pandora Planet.
        With just a few clicks, you can obtain a no-obligations in-principle
        approval for your home loan.
    </div>
    <div class="buttons">
        <a href="request.html"><img src="images/applynow.png" alt=""/>Apply</a>
    </div>
    <div class="text">
        <span class="heading">For existing customers</span>
    </div>
    <div class="text">We are committed to taking care of you
        throughout your loan journey with us. For modification your data,
        checking existing loans, or requesting new loans with us, please log
        in to our loan portal by your email address and PIN.
    </div>
    <div class="buttons">
        <a href="login.html"><img src="images/login.png" alt=""/>Log In</a>
    </div>
</div>

<%@ include file="../parts/footer_scripts.html" %>

<c:import url="doc-ready.jsp"/>

</body>
</html>