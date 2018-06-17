<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(function(){
    activate('<c:out value="${nav}" default="0"/>');
    <c:if test="${not empty processStatus}">
	    $(function() {
	      $("#dialog").dialog({
	        bgiframe: true,
	        modal: true,
	        closeOnEscape: true,
	        draggable: false,
	        buttons: {
	          Ok: function() {
	            $(this).dialog('close');
	          }
	        }
	      });
	    });
   </c:if>   
 });
</script>
