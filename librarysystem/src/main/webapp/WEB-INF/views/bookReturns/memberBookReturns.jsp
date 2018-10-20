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
                        	Days left
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
                    <c:if test="${bookReturns.size() > 0 }">
                        <c:forEach var="bookReturn" items="${bookReturns}">
                        	<c:choose>
                                <c:when test="${bookReturn.getStatus() == bookReturn.getStatusCodePending()}">
                                    <c:set var="bgClass" value="bg-warning" />
                                </c:when>
                                <c:when test="${bookReturn.getStatus() == bookReturn.getStatusCodePenalty()}">
                                    <c:set var="bgClass" value="bg-danger" />
                                </c:when>
                                <c:otherwise>
                                    <c:set var="bgClass" value="" />
                                </c:otherwise>
                            </c:choose>
                            <tr class='${bgClass}'>
                                <td>
                                    #${bookReturn.getId() }
                                </td>
                                <td>
                                    ${bookReturn.getStatusString() }
                                </td>
                                <td>
                                	<span class="countdown text-primary">${bookReturn.getLeftDate()}</span>
                                	<span class="hide for-sorting">
                                		<fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${bookReturn.getDate() }" />
                                	</span>
	                            </td>
                                <td>
                                	#${bookReturn.getUser().getId() }<br/>
                                    ${bookReturn.getUser().getName() }
                                </td>
                                <td>
                                    #${bookReturn.getBook().getId() }<br/>
                                    ${bookReturn.getBook().getName() }
                                </td>
                                <td class="nowrap">
                                	<a href="seeBookReturn?id=${bookReturn.getId()}&redirectUrl=memberBookReturns" class='btn btn-warning btn-xs'>
	                                	<i class="fa fa-eye"> </i>
	                                	See
	                                </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${bookReturns.size() == 0 }">
                        <tr class="noFiles">
                            <td colspan='5'>
                                No returns were found
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    