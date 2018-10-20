<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<fmt:setLocale value="en_US" scope="session"/>

    <jsp:include page="../header.jsp" />
    
    <section class="content-header">
        <h1>Books</h1>
    </section>
    
    <section class="content">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">${title }</h3>
            </div>
            <div class="box-body">
            <div class="table-responsive">
                <table class="table table-hover table-bordered dataTable" id="data-table">
                	<thead>
                    <tr>
                        <th>
                            ID
                        </th>
                        <th>
                            Status
                        </th>
                        <th>
                        	Date
                        </th>
                        <th>
                            User
                        </th>
                        <th>
                            Book
                        </th>
                        <th>
                            Actions
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${bookRequests.size() > 0 }">
                        <c:forEach var="bookRequest" items="${bookRequests}">
                        	<c:choose>
                                <c:when test="${bookRequest.getStatus() == bookRequest.getStatusCodeAccepted()}">
                                    <c:set var="bgClass" value="bg-success" />
                                </c:when>
                                <c:when test="${bookRequest.getStatus() == bookRequest.getStatusCodeDeclined()}">
                                    <c:set var="bgClass" value="bg-danger" />
                                </c:when>
                                <c:when test="${bookRequest.getStatus() == bookRequest.getStatusCodeRefused()}">
                                    <c:set var="bgClass" value="bg-danger" />
                                </c:when>
                                <c:otherwise>
                                    <c:set var="bgClass" value="" />
                                </c:otherwise>
                            </c:choose>
                            <tr class='${bgClass}'>
                                <td>
                                    #${bookRequest.getId() }
                                </td>
                                <td>
                                    ${bookRequest.getStatusString() }
                                </td>
                                <td>
                                	<fmt:formatDate pattern = "dd MMMM yyyy HH:mm" value = "${bookRequest.getDate() }" />
                                	<span class="hide for-sorting">
                                		<fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${bookRequest.getDate() }" />
                                	</span>
	                            </td>
                                <td>
                                	#${bookRequest.getUser().getId() }<br/>
                                    ${bookRequest.getUser().getName() }
                                </td>
                                <td>
                                    #${bookRequest.getBook().getId() }<br/>
                                    ${bookRequest.getBook().getName() }
                                </td>
                                <td class="nowrap">
                                	<a href="seeBookRequest?id=${bookRequest.getId()}&redirectUrl=memberBookRequests" class='btn btn-warning btn-xs'>
	                                	<i class="fa fa-eye"> </i>
	                                	See
	                                </a>
	                                <c:if test="${bookRequest.getStatus() == bookRequest.getStatusCodePending()}">
	                                   	<a href="seeBookRequest?id=${bookRequest.getId()}&redirectUrl=memberBookRequests" class='btn btn-danger btn-xs'>
		                                	<i class="fa fa-remove"> </i>
		                                	Refuse
		                                </a>
	                                </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${bookRequests.size() == 0 }">
                        <tr class="noFiles">
                            <td colspan='5'>
                                No requests were found
                            </td>
                        </tr>
                    </c:if>
                </tbody>
                </table>
            </div>
        </div>
    </section>
    
     <script>
    
	    if ($('#data-table').length > 0 && $('#data-table .noFiles').length == 0) {
			$('#data-table').DataTable({
				"aoColumns": [
					null,
					{sType: 'cur'},
					null,
					null,
					null
				],
				"aoColumnDefs":[{
			        "aTargets": [ 4 ],
			        "bSortable": false
				}]
			});
	    }
    </script>
    
    
    <%@include file="../footer.jsp" %>
    
    
    
    
    
    
    
    
    
    
    
    
    
    