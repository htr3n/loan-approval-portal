<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="isLogged" value="${sessionScope.theSesssionId != null}"/>
<div id="banner">
    <h1>WestBank Loan Portal</h1>
</div>
<ul id="tabmenu">
    <li>
        <c:if test="${!isLogged}">
            <a href="index.html">&nbsp;Home&nbsp;</a>
        </c:if>
    </li>
    <li>
    </li>
    <li>
        <c:if test="${!isLogged}">
            <a href="request.html">&nbsp;Loan Request&nbsp;</a>
        </c:if>
    </li>
    <li>
        <c:if test="${!isLogged}">
            <a href="login.html">&nbsp;Log in&nbsp;</a>
        </c:if>
    </li>
    <li>
        <c:if test="${isLogged}">
            <a href="portal.html">&nbsp;Loan Portal&nbsp;</a>
        </c:if>
    </li>
    <li>
        <c:if test="${isLogged}">
            <a href="profile.html">&nbsp;Profile&nbsp;</a>
        </c:if>
    </li>
    <li>
        <c:if test="${isLogged}">
            <a href="newrequest.html">&nbsp;New Request&nbsp;</a>
        </c:if>
    </li>
    <li>
        <c:if test="${isLogged}">
            <a href="logout.html">&nbsp;Log out&nbsp;</a>
        </c:if>
    </li>
</ul> 
