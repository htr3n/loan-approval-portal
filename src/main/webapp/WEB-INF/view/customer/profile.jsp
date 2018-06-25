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
        <fieldset id="pt3">
            <legend>1.</legend>
            <h3>Personal Information</h3>

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
            <legend>2.</legend>
            <h3>Contact Information</h3>
            <label for="borrowerStreet">Street and house number<span class="required">*</span></label>
            <form:input id="borrowerStreet" path="borrowerStreet" tabindex="51"/>
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
            <form:input path="borrowerEmail" id="borrowerEmail" tabindex="58" readonly="true"/>
            <form:errors path="borrowerEmail" cssClass="fieldError"/>
        </fieldset>

        <fieldset id="pt7">
            <legend>3.</legend>
            <h3>Change PIN</h3>
            <label for="newPin">New PIN</label>
            <form:password id="newPin" path="newPin" tabindex="71"/>
            <label for="newPinAgain">New PIN again</label>
            <form:password id="newPinAgain" path="newPinAgain" tabindex="72"/>
            <form:errors path="newPin" cssClass="fieldError"/>
        </fieldset>

        <fieldset id="last">
            <div id=divsubmit>
                <div class="buttons">
                    <a onclick="$('#applform').submit();"><img src="images/tick.png" alt=""/>Update</a>
                    <a class="negative" onclick="$('#applform')[0].reset();"><img src="images/reset.png"
                                                                                  alt=""/>Reset</a>
                </div>
            </div>
            <div id="disclaimer">By clicking the &#8220;Update&#8221; button,
                I am attaching my personal information and agreeing to the WestBank's
                Terms of Services Agreement; I agree to be bound by any modifications,
                changes, or revisions made by WestBank to the online services or
                to these Terms of Services.
                I understand that if I do not agree to these
                terms of use and privacy statements, I should refrain from using services
                provided by WestBank.
            </div>
        </fieldset>
    </div>
</form:form>
<%@ include file="../parts/footer_scripts.html" %>

<c:import url="doc-ready.jsp"/>

<script type="text/javascript">
    $(function () {

        $.datepicker.setDefaults(
            {
                showMonthAfterYear: false,
                changeMonth: true,
                changeYear: true,
                dateFormat: 'yyyy-mm-dd',
                buttonImage: '/portal/images/calendar.gif',
                buttonImageOnly: true,
                showOn: 'both'
            }
        );
        $("#borrowerDateOfBirth").datepicker(
            {
                yearRange: "-86:-16"
            }
        );
    });
</script>

</body>
</html>