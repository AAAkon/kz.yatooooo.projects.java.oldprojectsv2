<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <fmt:setLocale value="ru_RU" />
    
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
		                        	Name
		                        </th>
		                        <th>
		                            Author
		                        </th>
		                        <th>
		                            Edition
		                        </th>
		                        <th>
		                            Stock
		                        </th>
		                        <th>
		                            Actions
		                        </th>
		                    </tr>
	                    </thead>
	                    <tbody>
		                    <c:if test="${books.size() > 0 }">
		                        <c:forEach var="book" items="${books}">
		                            <tr>
		                                <td>
		                                    #${book.getId() }
		                                </td>
		                                <td>
			                            	${book.getName() }
			                            </td>
		                                <td>
		                                    ${book.getAuthor() }
		                                </td>
		                                <td>
		                                    ${book.getEdition() }
		                                </td>
		                                <td>
		                                    ${book.getStock() }
		                                </td>
		                                <td class="nowrap">
		                                	<a href="seeBook?id=${book.getId()}" class='btn btn-warning btn-xs'>
			                                	<i class="fa fa-eye"> </i>
			                                	See
			                                </a>
			                                <c:if test="${loggedUser != null }">
				                                <c:if test="${loggedUser.isMember() }">
				                                	<a href="seeBook?id=${book.getId()}" class='btn btn-primary btn-xs'>
					                                	<i class="fa fa-send"> </i>
					                                	Request
					                                </a>
				                                </c:if>
			                                    <c:if test="${loggedUser.isAdmin() }">
			                                    	<a href="editBook?id=${book.getId()}" class='btn btn-success btn-xs'>
					                                	<i class="fa fa-pencil"> </i>
					                                	Edit
					                                </a>
					                                <a href="deleteBook?id=${book.getId()}" class='btn btn-danger btn-xs'>
					                                	<i class="fa fa-remove"> </i>
					                                    Delete
					                                </a>
			                                    </c:if>
		                                    </c:if>
		                                </td>
		                            </tr>
		                        </c:forEach>
		                    </c:if>
		                    <c:if test="${books.size() == 0 }">
		                        <tr class="noFiles">
		                            <td colspan='6'>
		                                No books were found
		                            </td>
		                        </tr>
		                    </c:if>
		                </tbody>
	                </table>
	                <c:if test="${loggedUser.isAdmin() }">
		                <a href='addBook' class='btn btn-primary'><i class='fa fa-plus'></i> Add book</a><hr/>
	                </c:if>
	             </div>
            </div>
        </div>
    </section>
    
     <script>
    
	    if ($('#data-table').length > 0 && $('#data-table .noFiles').length == 0) {
			$('#data-table').DataTable({
				"aoColumns": [
					null,
					null,
					null,
					null,
					null,
					null
				],
				"aoColumnDefs":[{
			        "aTargets": [ 5 ],
			        "bSortable": false
				}],
				language: "ru"
			});
	    }
    </script>
    
    
    <%@include file="../footer.jsp" %>
    
    
    
    
    
    
    
    
    
    
    
    
    
    