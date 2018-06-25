<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Credit Broker Portal</title>
    <%@ include file="../parts/staff_header_css.html" %>
</head>
<body>
<c:import url="message.jsp"/>
<div id="content">${processStatus}
    <h2>${staff.firstName} ${staff.lastName} [ID:${staff.staffId}, Role:${role}]
        | <a onclick="doSubmit('logout','');">Logout</a>
        | <a onclick="doSubmit('reload');"><img id="refresh" alt="" src="../images/refresh.png">Reload</a>
    </h2>
    <form:form method="post" modelAttribute="loanList" id="form">
        <form:hidden path="loanFileId" id="loanFileId"/>
        <form:hidden path="action" id="action"/>
        <c:choose>
            <c:when test="${loans != null && fn:length(loans) gt 0}">
                <div id="twotables">
                    <table class="stripMe">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Borrower(s)</th>
                            <th>Residence</th>
                            <th>Estate</th>
                            <th>Price</th>
                            <th>Personal contrib.</th>
                            <th>Loan Amount</th>
                            <th>Interest</th>
                            <th>Loan Term</th>
                            <th>Start Date</th>
                            <th>Created Date</th>
                            <th>Status</th>
                            <th>Awaiting Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${loans}" var="loan" varStatus="loopVar">
                            <tr>
                                <td>${loopVar.index}</td>
                                <td><a>
                                        ${loan.borrower.firstName} ${loan.borrower.lastName}
                                </a>
                                    <c:if test="${loan.coBorrower != null}">
                                        /<a>
                                        ${loan.coBorrower.firstName} ${loan.coBorrower.lastName}
                                        </a>
                                    </c:if>
                                </td>
                                <td>${loan.residenceType}</td>
                                <td title="${loan.estateLocation}">${loan.estateType}</td>
                                <td>
                                    <fmt:formatNumber value='${loan.totalPurchasePrice}' type="currency"
                                                      groupingUsed="true" maxFractionDigits="0"/>
                                </td>
                                <td>
                                    <fmt:formatNumber value='${loan.personalCapitalContribution}' type="currency"
                                                      groupingUsed="true" maxFractionDigits="0"/>
                                </td>
                                <td>
                                    <fmt:formatNumber value='${loan.loanAmount}' type="currency" groupingUsed="true"
                                                      maxFractionDigits="0"/>
                                </td>
                                <td>${loan.interestRate}</td>
                                <td>${loan.loanTerm}</td>
                                <td nowrap="nowrap"><fmt:formatDate
                                        value='${loan.settlementDate}' type="both"
                                        pattern="yyyy-MM-dd"/></td>
                                <td nowrap="nowrap"><fmt:formatDate
                                        value='${loan.createdDate}' type="both"
                                        pattern="yyyy-MM-dd"/></td>
                                <td width="160px" title="${loan.description}">
                                    <a>${loan.status}</a>
                                </td>
                                <td width="105px">
                                    <c:if test="${loan.status eq 'INITIALIZED'
										and loan.accessSensitiveData == true}">
                                        <div class="buttons">
                                            <a class="positive" onclick="doSubmit('accept','${loan.loanFileId}');">
                                                <img src="../images/tick.png" alt=""/>Accept</a>
                                        </div>
                                    </c:if>
                                    <c:set scope="page" var="mailto" value="mailto:"/>
                                    <c:set scope="page" var="subject" value="?subject=LoanID_"/>
                                    <c:set scope="page" var="subject1" value="_grant_an_access_to_sensitive_data"/>
                                    <c:set scope="page" var="senMailTo"
                                           value="${mailto}${loan.borrower.email}${subject}${loopVar.index}${subject1}"/>
                                    <c:if test="${loan.status eq 'INITIALIZED'
										and loan.accessSensitiveData == false}">
                                        <div class="buttons">
                                            <a href=${senMailTo}>
                                                <img src="../images/info.png" alt=""/>Send Email</a>
                                        </div>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th colspan="13"></th>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <p>There is no awaiting loan request.</p>
            </c:otherwise>
        </c:choose>
    </form:form>
</div>
<%@ include file="../parts/footer_scripts.html" %>
<script type="text/javascript">
    $(document).ready(function () {
        $('table tr').mouseover(function () {
            $(this).addClass("over");
        });
        $('table tr').mouseout(function () {
            $(this).removeClass("over");
        });
        $('table tr:even').addClass('alt');
    });

    function doSubmit(action, loanFileId) {
        $("#action").val(action);
        $("#loanFileId").val(loanFileId);
        $("#form").submit();
    }
</script>
<c:import url="doc-ready.jsp"/>
</body>
</html>