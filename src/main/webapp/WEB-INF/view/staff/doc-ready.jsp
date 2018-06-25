<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
    // check if there is any error to show the error message
    <c:if test="${not empty sessionScope.processStatus}">    
       <c:choose>
          <c:when test='${sessionScope.processStatus == "OK"}'>
          showOpaque("success");       
          </c:when>
          <c:when test='${sessionScope.processStatus == "ERROR"}'>
           showOpaque("error");
          </c:when>
       </c:choose>          
    </c:if>
 });
</script>
