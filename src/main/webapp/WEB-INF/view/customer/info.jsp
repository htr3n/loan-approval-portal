<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <meta http-equiv="Pragma" content="no-cache">
   <meta http-equiv="Expires" content="0">
   <meta http-equiv="Cache-Control" content="no-cache">  
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Online Loan Application</title>
    <%@ include file="../parts/header_css.html" %>
</head>
<body>
  <c:import url="tab.jsp"/>
  <div id="content">  
     <div id="applsuccess">
        <p>
          <strong>Dear ${customerTitle} ${customerName}</strong>,
        </p>
        <p>Thank you for choosing our loan providing service. 
        Your personal data have been securely stored in our system. 
        Information to access and manage these data has been sent to your email address: <strong>${customerEmail}</strong>.</p>   
        <p>In addition, your loan request has been successfully submitted to our system for considering. 
        The whole approval process might take approximately <strong>10-20</strong> working days.
         
        After that, approval results will be sent to the notification box of your account.
        Please login and check your notification box during the aforementioned period.  
        </p>
        <p>
        In case of a successful approval, a loan contract will be sent to you. By law, you will have <strong>7 days</strong> for judging the loan contract. After that, we would like to ask you to digitally sign the final loan contract and send it back to us within <strong>2 months</strong>. 
        As soon as we receive the loan contract with your digital signature, the loan will be properly settled and valid. 
        </p>
        <p>In case you have any problem, please contact our service support at phone number +43-1-08020304 or email <strong>customer@westbank.com</strong>.</p>
        <p>
        Sincerely yours,<br/>
        General Director of WestBank.<br/>
        <strong>Robert Landon</strong><br/>
        </p>
     </div>
   </div>
  <%@ include file="../parts/footer_scripts.html" %>
  <script type="text/javascript">
      $(document).ready(function(){
          activate('<c:out value="${sessionScope.nav}" default="0"/>');
      });
  </script>
</body>
</html>
