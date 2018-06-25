<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Dev List</title>
    <link rel="stylesheet" type="text/css" href="css/portal.css" />
    <style type="text/css">
        body {
            font-family: sans-serif;
            font-size: 10px;
        }
        th {
            background: #898B5E;
            color: #fff;
            padding: 4px 4px !important;
            text-align: center !important;
        }

        td {
            height: 24px !important;
            white-space: nowrap;
        }

        hr {
            margin-top: 20px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<h2>Table: Customer</h2>
<c:if test="${fn:length(customers) gt 0}">
    <table class="stripeMe task">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Full Name</th>
            <th>Date Of Birth</th>
            <th>Street</th>
            <th>City</th>
            <th>State</th>
            <th>Zip</th>
            <th>Country</th>
            <th>Phone</th>
            <th>Mobile-phone</th>
            <th>Email</th>
            <th>Marital</th>
            <th>#Children</th>
            <th>PIN</th>
            <th>Occupation</th>
            <th>LoS</th>
            <th>Income</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.title}</td>
                <td>${customer.firstName}${customer.lastName}</td>
                <td>
                    <fmt:formatDate value='${customer.dateOfBirth}' type="date" pattern="dd.MM.yyyy"/>
                </td>
                <td>${customer.address.street}</td>
                <td>${customer.address.city}</td>
                <td>${customer.address.state}</td>
                <td>${customer.address.zipcode}</td>
                <td>${customer.address.country}</td>
                <td>${customer.phone}</td>
                <td>${customer.mobilePhone}</td>
                <td>${customer.email}</td>
                <td>${customer.maritalStatus}</td>
                <td>${customer.numberOfChildren}</td>
                <td>${customer.pin}</td>
                <td>${customer.occupation}</td>
                <td>${customer.lengthOfService}</td>
                <td>
                    <fmt:formatNumber value='${customer.income}' type="currency" groupingUsed="true"
                                      maxFractionDigits="0"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<hr/>
<!-- Test to show loans or not -->
<h2>Table: Loan</h2>
<c:if test="${fn:length(loans) gt 0}">
    <table class="stripeMe task">
        <thead>
        <tr>
            <th>#</th>
            <th>Borrower(s)</th>
            <th>Loan Amount</th>
            <th>Interest Rate</th>
            <th>Loan Term</th>
            <th>Personal contrib.</th>
            <th>Residence</th>
            <th>Estate</th>
            <th>Settlement Date</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Updated By</th>
            <th>Risk</th>
            <th>Status</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${loans}" var="loan" varStatus="loopVar">
            <tr>
                <td title="${loan.contract}">${loopVar.index}</td>
                <td>${loan.borrower.firstName} ${loan.borrower.lastName}
                    <c:if test="${loan.coBorrower != null}">
                        /${loan.coBorrower.firstName} ${loan.coBorrower.lastName}
                    </c:if>
                </td>
                <td><fmt:formatNumber value='${loan.loanAmount}'
                                      type="currency" groupingUsed="true" maxFractionDigits="0"/>
                </td>
                <td>${loan.interestRate}</td>
                <td>${loan.loanTerm}</td>
                <td>
                    <fmt:formatNumber
                            value='${loan.personalCapitalContribution}' type="currency"
                            groupingUsed="true" maxFractionDigits="0"/>
                </td>
                <td>${loan.residenceType}</td>
                <td>${loan.estateType}</td>
                <td>
                    <fmt:formatDate value='${loan.settlementDate}' type="date" pattern="yyyy-MM-dd"/>
                </td>
                <td title="${loan.createdBy.staffId}">
                    <fmt:formatDate value='${loan.createdDate}' type="date" pattern="yyyy-MM-dd"/>
                </td>
                <td><fmt:formatDate value='${loan.updatedDate}' type="date"
                                    pattern="yyyy-MM-dd"/></td>
                <td>${loan.updatedBy.staffId}/${loan.updatedByRole}</td>
                <td>${loan.risk}</td>
                <td>${loan.status}</td>
                <td>${loan.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<hr/>
<h2>Table: Staff</h2>
<c:if test="${fn:length(staff) gt 0}">
    <div style="width: 50%">
        <table class="stripeMe task">
            <thead>
            <tr>
                <th>Staff ID</th>
                <th>Name</th>
                <th>Password</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${staff}" var="s">
                <tr>
                    <td>${s.staffId}</td>
                    <td>${s.firstName}${s.lastName}</td>
                    <td>${s.password}</td>
                    <td>
                        <c:forEach items="${s.role}" var="role">
                            ${role.roleName}
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
<hr/>
<h2>Loan Contract</h2>
<c:choose>
    <c:when test="${contracts != null && fn:length(contracts) gt 0}">
        <table class="stripMe task">
            <thead>
            <tr>
                <th>#</th>
                <th>Borrower(s)</th>
                <th>Monthly Payment</th>
                <th>Bank</th>
                <th>Customer signed</th>
                <th>Manager signed</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${contracts}" var="contract" varStatus="loopVar">
                <tr>
                    <td>${loopVar.index}</td>
                    <td><a> ${contract.borrower.firstName}
                            ${contract.borrower.lastName} </a> <c:if
                            test="${contract.coBorrower != null}">
                        /<a> ${contract.coBorrower.firstName}
                        ${contract.coBorrower.lastName} </a>
                    </c:if></td>
                    <td><fmt:formatNumber
                            value='${loan.contract.monthlyPayment}' type="currency"
                            groupingUsed="true" maxFractionDigits="0"/></td>
                    <td title="${contract.agency.agencyCode}">${contract.agency.bankName}</td>
                    <td><fmt:formatDate value='${contract.signedByCustomer}'
                                        type="date" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value='${contract.signedByManager}'
                                        type="date" pattern="yyyy-MM-dd"/></td>
                    <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
</c:choose>
<%@ include file="../parts/footer_scripts.html" %>
</body>
</html>