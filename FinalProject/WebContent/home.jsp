<%if(request.getSession().getAttribute("userN")!=null && request.getSession().getAttribute("userI")!=null){ %>
	
	<%@include file="/pages/authorized/home.jsp" %>
	
<%}else{%>
	
	<%@include file="/pages/guest/home.jsp" %>

<%}%>