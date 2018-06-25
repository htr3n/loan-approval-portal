<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Loan Request</title>
    <%@ include file="../parts/header_css.html" %>
</head>
<body>
<c:import url="tab.jsp"/>
<c:import url="message.jsp"/>
<form:form modelAttribute="applicationForm" id="applform" method="post">
    <div id="content">
        <fieldset id="pt1">
            <legend>1.</legend>
            <h3>Loan Request</h3>

            <label for="loanReason">Purpose of Loan <span class="required">*</span></label>
            <form:select id="loanReason" path="loanReason" tabindex="11">
                <form:option value="" label=""/>
                <form:option value="Home Mortgage" label="Home Mortgage"/>
                <form:option value="Refinance" label="Refinance"/>
                <form:option value="Debt Consolidation" label="Debt Consolidation"/>
                <form:option value="Second Mortgage" label="Second Mortgage"/>
                <form:option value="Home Equity" label="Home Equity"/>
                <form:option value="Home Improvement" label="Home Improvement"/>
                <form:option value="Bad Credit Mortgage" label="Bad Credit Mortgage"/>
            </form:select>
            <form:errors path="loanReason" cssClass="fieldError"/>

            <label for="residenceType">Residence Type<span class="required">*</span></label>
            <form:select path="residenceType" id="residenceType" tabindex="12">
                <form:option value="" label=""/>
                <form:option value="MAIN_HOUSE" label="Main House"/>
                <form:option value="SECOND_HOUSE" label="Second House"/>
                <form:option value="OTHER" label="Other"/>
            </form:select>
            <form:errors path="residenceType" cssClass="fieldError"/>

            <label for="estateType">Estate Type<span class="required">*</span></label>
            <form:select path="estateType" id="estateType" tabindex="13">
                <form:option value="" label=""/>
                <form:option value="FLAT" label="Flat"/>
                <form:option value="HOUSE" label="House"/>
                <form:option value="PARKING" label="Parking"/>
                <form:option value="OTHER" label="Other"/>
            </form:select>
            <form:errors path="estateType" cssClass="fieldError"/>

            <label for="estateAddress">Estate address<span class="required">*</span></label>
            <form:input id="estateAddress" path="estateAddress" tabindex="14"/>
            <form:errors path="estateAddress" cssClass="fieldError"/>

            <label for="totalPurchasePrice">Total Purchase Price ($)<span class="required">*</span></label>
            <form:input path="totalPurchasePrice" id="totalPurchasePrice" tabindex="15"/>
            <form:errors path="totalPurchasePrice" cssClass="fieldError"/>

            <label for="personalCapitalContribution">Personal Contribution ($)<span class="required">*</span></label>
            <form:input path="personalCapitalContribution" id="personalCapitalContribution" tabindex="16"/>
            <form:errors path="personalCapitalContribution" cssClass="fieldError"/>

            <label for="loanAmount">Loan Amount ($)<span class="required">*</span></label>
            <form:input path="loanAmount" id="loanAmount" tabindex="17"/>
            <form:errors path="loanAmount" cssClass="fieldError"/>

            <label for="loanTerm">Loan Term (years)<span class="required">*</span></label>
            <form:select path="loanTerm" id="loanTerm" tabindex="18">
                <form:option value="0" label=""/>
                <c:forEach begin="1" end="50" var="term">
                    <form:option value="${term}" label="${term}"/>
                </c:forEach>
            </form:select>
            <form:errors path="loanTerm" cssClass="fieldError"/>

            <label for="interestRate">Interest Rate (per annum)</label>
            <form:input path="interestRate" id="interestRate" tabindex="19" readonly="true"/>
            <form:errors path="interestRate" cssClass="fieldError"/>

            <label for="startDate">Expected Start Date (yyyy-mm-dd)</label>
            <form:input path="startDate" id="startDate" tabindex="20"/>
            <form:errors path="startDate" cssClass="fieldError"/>

        </fieldset>

        <fieldset id="pt3">
            <legend>2.</legend>
            <h3>Personal Information</h3>

            <label for="borrowerCustomerId">Customer ID:<br/>(for existing customer)</label>
            <form:input id="borrowerCustomerId" path="borrowerCustomerId" tabindex="29"/>

            <label for="borrowerTitle">Title</label>
            <form:select path="borrowerTitle" id="borrowerTitle" tabindex="30">
                <form:option value=""/>
                <c:forTokens items="Dr,Miss,Mr,Mrs,Prof" delims="," var="title">
                    <form:option value="${title}"/> label="${title}" />
                </c:forTokens>
            </form:select>
            <form:errors path="borrowerTitle" cssClass="fieldError"/>

            <label for="borrowerFirstName">First Name <span class="required">*</span></label>
            <form:input id="borrowerFirstName" path="borrowerFirstName" tabindex="31"/>
            <form:errors path="borrowerFirstName" cssClass="fieldError"/>

            <label for="borrowerLastName">Last Name <span class="required">*</span></label>
            <form:input id="borrowerLastName" path="borrowerLastName" tabindex="33"/>
            <form:errors path="borrowerLastName" cssClass="fieldError"/>

            <label for="borrowerDateOfBirth">Date of Birth (yyyy-mm-dd)<span class="required">*</span></label>
            <form:input path="borrowerDateOfBirth" id="borrowerDateOfBirth" tabindex="34"/>
            <form:errors path="borrowerDateOfBirth" cssClass="fieldError"/>

            <label for="borrowerMaritalStatus">Marital Status</label>
            <form:select path="borrowerMaritalStatus" id="borrowerMaritalStatus" tabindex="37">
                <form:option value="OTHER" label=""/>
                <form:option value="MARRIED" label="Married"/>
                <form:option value="NOT_MARRIED" label="Not married"/>
                <form:option value="OTHER" label="Other"/>
            </form:select>

            <label for="borrowerNumberOfChildren">Number of Children</label>
            <form:select path="borrowerNumberOfChildren" id="borrowerNumberOfChildren" tabindex="38">
                <c:forEach begin="0" end="10" var="num">
                    <form:option value="${num}" label="${num}"/>
                </c:forEach>
            </form:select>
            <label for="borrowerOccupation">Occupation <span class="required">*</span></label>
            <form:input id="borrowerOccupation" path="borrowerOccupation" tabindex="39"/>
            <form:errors path="borrowerOccupation" cssClass="fieldError"/>

            <label for="borrowerIncome">Annual Income ($)<span class="required">*</span></label>
            <form:input id="borrowerIncome" path="borrowerIncome" tabindex="40"/>
            <form:errors path="borrowerIncome" cssClass="fieldError"/>

            <label for="borrowerLengthOfService">Length of Service (years)<span class="required">*</span></label>
            <form:select id="borrowerLengthOfService" path="borrowerLengthOfService" tabindex="41">
                <form:option value="-1" label="Please select"/>
                <form:option value="0" label="Less than 1 year"/>
                <c:forEach begin="1" end="15" var="term">
                    <form:option value="${term}" label="${term}"/>
                </c:forEach>
                <form:option value="16" label="More than 15 years"/>
            </form:select>
            <form:errors path="borrowerLengthOfService" cssClass="fieldError"/>

        </fieldset>

        <fieldset id="pt5">
            <legend>3.</legend>
            <h3>Contact Information</h3>
            <label for="borrowerStreet">Street and house number<span class="required">*</span></label>
            <form:input id="borrowerStreet" path="borrowerStreet" tabindex="21"/>
            <form:errors path="borrowerStreet" cssClass="fieldError"/>

            <label for="borrowerCity">City <span class="required">*</span></label>
            <form:input id="borrowerCity" path="borrowerCity" tabindex="52"/>
            <form:errors path="borrowerCity" cssClass="fieldError"/>

            <label for="borrowerState">State/Province/Region</label>
            <form:input id="borrowerState" path="borrowerState" tabindex="53"/>

            <label for="borrowerZipcode">Postal / Zip Code <span class="required">*</span></label>
            <form:input id="borrowerZipcode" path="borrowerZipcode" tabindex="54"/>
            <form:errors path="borrowerZipcode" cssClass="fieldError"/>

            <label for="borrowerCountry">Country <span class="required">*</span></label>
            <form:input id="borrowerCountry" path="borrowerCountry" tabindex="55"/>
            <form:errors path="borrowerCountry" cssClass="fieldError"/>

            <label for="borrowerPhone">Phone (inc. country code) <span class="required">*</span></label>
            <form:input path="borrowerPhone" id="borrowerPhone" tabindex="56"/>
            <form:errors path="borrowerPhone" cssClass="fieldError"/>

            <label for="borrowerMobilePhone">Mobile Phone (inc. country code)</label>
            <form:input path="borrowerMobilePhone" id="borrowerMobilePhone" tabindex="57"/>
            <form:errors path="borrowerMobilePhone" cssClass="fieldError"/>

            <label for="borrowerEmail">Email <span class="required">*</span></label>
            <form:input path="borrowerEmail" id="borrowerEmail" tabindex="58"/>
            <form:errors path="borrowerEmail" cssClass="fieldError"/>
        </fieldset>

        <fieldset id="pt6">
            <legend>4.</legend>
            <h3>Access Sensitive Data</h3>

            <label for="accessSensitiveData">Give Access to sensitive data?
                <form:checkbox id="accessSensitiveData" path="accessSensitiveData" onclick="toggleAccessSensitiveData()"
                               tabindex="60"/>

            </label>


        </fieldset>

        <fieldset id="pt9">
            <legend>5.</legend>
            <h3>Co-Borrower</h3>

            <label for="hasCoborrower">Has a co-borrower?
                <form:checkbox id="hasCoborrower" path="hasCoborrower" onclick="toggleCoBorrower();" tabindex="91"/>
            </label>
            <div id="divCoBorrower" style="display: none;">

                <label for="coborrowerCustomerId">Co-borrower ID:<br/>(for existing customer)</label>
                <form:input id="coborrowerCustomerId" path="coborrowerCustomerId" tabindex="91"/>

                <label for="coborrowerTitle">Title</label>
                <form:select path="coborrowerTitle" id="coborrowerTitle" tabindex="92">
                    <form:option value=""/>
                    <c:forTokens items="Dr,Miss,Mr,Mrs,Prof" delims="," var="title">
                        <form:option value="${title}"/> label="${title}" />
                    </c:forTokens>
                </form:select>
                <form:errors path="coborrowerTitle" cssClass="fieldError"/>

                <label for="coborrowerFirstName">First Name <span class="required">*</span></label>
                <form:input id="coborrowerFirstName" path="coborrowerFirstName" tabindex="93"/>
                <form:errors path="coborrowerFirstName" cssClass="fieldError"/>

                <label for="coborrowerLastName">Last Name <span class="required">*</span></label>
                <form:input id="coborrowerLastName" path="coborrowerLastName" tabindex="94"/>
                <form:errors path="coborrowerLastName" cssClass="fieldError"/>

                <label for="coborrowerDateOfBirth">Date of Birth (yyyy-mm-dd)<span class="required">*</span></label>
                <form:input path="coborrowerDateOfBirth" id="coborrowerDateOfBirth" tabindex="95"/>
                <form:errors path="coborrowerDateOfBirth" cssClass="fieldError"/>

                <label for="coborrowerEmail">Email <span class="required">*</span></label>
                <form:input path="coborrowerEmail" id="coborrowerEmail" tabindex="58"/>
                <form:errors path="coborrowerEmail" cssClass="fieldError"/>

                <label for="coborrowerOccupation">Occupation <span class="required">*</span></label>
                <form:input id="coborrowerOccupation" path="coborrowerOccupation" tabindex="98"/>
                <form:errors path="coborrowerOccupation" cssClass="fieldError"/>

                <label for="coborrowerIncome">Annual Income ($)<span class="required">*</span></label>
                <form:input id="coborrowerIncome" path="coborrowerIncome" tabindex="99"/>
                <form:errors path="coborrowerIncome" cssClass="fieldError"/>

                <label for="coborrowerLengthOfService">Length of Service (years)<span class="required">*</span></label>
                <form:select id="coborrowerLengthOfService" path="coborrowerLengthOfService" tabindex="100">
                    <form:option value="-1" label="Please select"/>
                    <form:option value="0" label="Less than 1 year"/>
                    <c:forEach begin="1" end="15" var="term">
                        <form:option value="${term}" label="${term}"/>
                    </c:forEach>
                    <form:option value="16" label="More than 15 years"/>
                </form:select>
                <form:errors path="coborrowerLengthOfService" cssClass="fieldError"/>

            </div>
        </fieldset>


        <fieldset id="last">
            <div id=divsubmit>
                <div class="buttons">
                    <a onclick="$('#applform').submit();"><img src="images/tick.png" alt=""/>Submit</a>
                    <a class="negative" onclick="$('#applform')[0].reset();"><img src="images/reset.png"
                                                                                  alt=""/>Reset</a>
                </div>
            </div>
            <div id="disclaimer">By clicking the &#8220;Submit&#8221; button,
                I am attaching my personal information and agreeing to WestBank's
                Terms of Services Agreement; I agree to be bound by any modifications,
                changes, or revisions made by WestBank to the online services or to these Terms of Services.

                I understand that if I do not agree to these terms of use and
                privacy statements, I should refrain from using services provided by WestBank.
            </div>
        </fieldset>
    </div>
</form:form>

<%@ include file="../parts/footer_scripts.html" %>

<script type="text/javascript">
    function toggleCoBorrower() {
        var hasCoBorrower = $('#hasCoborrower:checked').val();
        if (hasCoBorrower == 'true')
            $('#divCoBorrower').show();
        else
            $('#divCoBorrower').hide();
    }

    function toggleAccessSensitiveData() {
        var accessSensitiveData = $('#accessSensitiveData:checked').val();
        //alert(accessSensitiveData);

    }

    $(function () {
        $.datepicker.setDefaults(
            {
                showMonthAfterYear: false,
                changeMonth: true,
                changeYear: true,
                dateFormat: 'yyyy-mm-dd',
                buttonImage: '/portal/images/calendar.gif',
                buttonImageOnly: true
            }
        );
        $("#borrowerDateOfBirth").datepicker(
            {
                yearRange: "-86:-16"
            }
        );
        $("#coborrowerDateOfBirth").datepicker(
            {
                yearRange: "-86:-16"
            }
        );
        $("#startDate").datepicker({minDate: 0, maxDate: '+1Y'});
    });
</script>

<c:import url="doc-ready.jsp"/>

</body>
</html>
