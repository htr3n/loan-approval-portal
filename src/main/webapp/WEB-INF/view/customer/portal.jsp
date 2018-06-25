<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <title>Customer Loan Portal</title>

    <%@ include file="../parts/header_css.html" %>

</head>
<body>
<c:import url="tab.jsp"/>
<c:import url="message.jsp"/>
<div id="content">
    <form:form method="post" modelAttribute="loanList" id="loanListForm">
        <form:hidden path="loanFileId" id="loanFileId"/>
        <form:hidden path="contractId" id="contractId"/>
        <form:hidden path="action" id="action"/>
        <h2>Welcome ${customer.title} ${customer.firstName} ${customer.lastName}</h2>
        <c:choose>
            <c:when test="${loans != null && fn:length(loans) gt 0}">
                <div id="runningHead">
                    <a onclick="doSubmit('reload');">
                        <img id="refresh" alt="" src="images/refresh.png">Reload</a>
                </div>
                <h3>Loan Request</h3>
                <table class="stripeMe task">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Co-borrower</th>
                        <th>Residence</th>
                        <th>Estate</th>
                        <th>Price</th>
                        <th>Contribution</th>
                        <th>Amount</th>
                        <th>Term</th>
                        <th>Interest Rate</th>
                        <th>Monthly Payment</th>
                        <th>Created Date</th>
                        <th>Start Date</th>
                        <th>Status</th>
                        <th>Provider signed</th>
                        <th>Customer signed</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${loans}" var="loan" varStatus="loopVar">
                        <tr>
                            <td><a>${loopVar.index}</a></td>
                            <td>
                                <c:if test="${loan.coBorrower != null}">
                                    <a>
                                            ${loan.coBorrower.firstName} ${loan.coBorrower.lastName}
                                    </a>
                                </c:if>
                            </td>
                            <td>${loan.residenceType}</td>
                            <td title="${loan.estateLocation}">${loan.estateType}</td>
                            <td>
                                <fmt:formatNumber value='${loan.totalPurchasePrice}' type="currency" groupingUsed="true"
                                                  maxFractionDigits="0"/>
                            </td>
                            <td>
                                <fmt:formatNumber value='${loan.personalCapitalContribution}' type="currency"
                                                  groupingUsed="true" maxFractionDigits="0"/>
                            </td>
                            <td>
                                <fmt:formatNumber value='${loan.loanAmount}' type="currency" groupingUsed="true"
                                                  maxFractionDigits="0"/>
                            </td>
                            <td>${loan.loanTerm} years</td>
                            <td>${loan.interestRate}</td>
                            <td>
                                <fmt:formatNumber value='${loan.contract.monthlyPayment}' type="currency"
                                                  groupingUsed="true" maxFractionDigits="0"/>
                            </td>
                            <td nowrap="nowrap"><fmt:formatDate
                                    value='${loan.createdDate}' type="both"
                                    pattern="yyyy-MM-dd"/></td>
                            <td nowrap="nowrap"><fmt:formatDate
                                    value='${loan.settlementDate}' type="both"
                                    pattern="yyyy-MM-dd"/></td>
                            <td width="160px" title="${loan.description}">
                                <a>${loan.status}</a>
                            </td>
                            <td>
                                <fmt:formatDate value='${loan.contract.signedByManager}'
                                                type="date" pattern="yyyy-MM-dd"/>
                            </td>
                            <td>
                                <fmt:formatDate value='${loan.contract.signedByCustomer}'
                                                type="date" pattern="yyyy-MM-dd"/>
                            </td>
                            <td style="width:150px!important;">
                                <c:choose>
                                    <c:when test="${loan.contract.signedByManager != null
                                   and loan.contract.signedByCustomer == null
                                   and loan.status != 'CANCELED'
                                   and loan.status != 'REJECTED'}">
                                        <div class="buttons">
                                            <a class="positive"
                                               onclick="doSubmit('sign','${loan.loanFileId}', '${loan.contract.contractId}');">
                                                <img src="images/sign.png" alt=""/>Sign</a>
                                            <a class="negative"
                                               onclick="doSubmit('cancel','${loan.loanFileId}', '${loan.contract.contractId}');">
                                                <img src="images/cross.png" alt=""/>Cancel</a>
                                        </div>
                                    </c:when>

                                    <c:when test="${loan.status == 'INITIALIZED'
                                   and loan.accessSensitiveData == false}">
                                        <div class="buttons">
                                            <a class="positive" onclick="doSubmit('grant','${loan.loanFileId}');">
                                                <img src="images/success.png" alt=""/>Grant Access</a>
                                            <a class="positive" onclick="doSubmit('deny','${loan.loanFileId}');">
                                                <img src="images/error.png" alt=""/>Deny Access</a>
                                        </div>
                                    </c:when>

                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th colspan="16"></th>
                    </tr>
                    </tfoot>
                </table>
            </c:when>
            <c:otherwise>
                <h3>
                    You currently do not have any existing loan request.<br/>
                    To request a new loan, click <a onclick="javascript:window.location='newrequest.html';">here</a>.
                </h3>
            </c:otherwise>
        </c:choose>
    </form:form>
</div>
<%@ include file="../parts/footer_scripts.html" %>
<c:import url="doc-ready.jsp"/>
<script type="text/javascript">
    function doSubmit(action, loanFileId, contractId) {
        $("#action").val(action);
        $("#contractId").val(contractId);
        $("#loanFileId").val(loanFileId);
        $("#loanListForm").submit();
    }
</script>

</body>
</html>