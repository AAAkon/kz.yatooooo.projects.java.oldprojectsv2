<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <jsp:include page="../header.jsp" />
    
    <section class="content-header">
        <h1>Books</h1>
        <span></span>
    </section>
    
    <section class="content">
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title">
                    ${title}
                </h3>
            </div>
            <div class="box-body">
            
            	<c:choose>
	                <c:when test="${book != null}">
						<c:choose>
			                <c:when test="${status == '#saved'}">
			                    <div class="alert alert-primary" style='text-align:center'>
			                        All changes was saved<br/> 
			                        <a href='books'>Back</a>
			                    </div>
			                </c:when>
			                <c:otherwise>
		                        <div class='row'>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Name *</label> 
		                                    <input type='text' class='form-control' name='name' value="${book.getName()}" disabled/>
		                                </div>
		                            </div>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Author *</label> 
		                                    <input type='text' class='form-control' name='author' value="${book.getAuthor()}" disabled/>
		                                </div>
		                            </div>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Edition *</label> 
		                                    <input type='text' class='form-control' name='edition' value="${book.getEdition()}" disabled/>
		                                </div>
		                            </div>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Stock *</label> 
		                                    <input type='text' class='form-control' name='stock' value="${book.getStock()}" disabled/>
		                                </div>
		                            </div>
		                        </div>
		                        <c:if test="${loggedUser != null }">
			                        <c:if test="${loggedUser.isMember() }">
				                        <a class='btn btn-primary' 
				                               href='sendBookRequest?bookId=${book.id}'
				                               onclick="return confirm('Are you sure want to send request?')">
				                           <i class='fa fa-send'> </i>
				                           Send request
				                        </a>
			                        </c:if>
			                 	    <c:if test="${loggedUser.isAdmin() }">
				                       	<a href="editBook?id=${book.getId()}" class='btn btn-success'>
					                      	<i class="fa fa-pencil"> </i>
					                      	Edit
				                        </a>
				                        <a href="deleteBook?id=${book.getId()}" class='btn btn-danger'>
					                      	<i class="fa fa-remove"> </i>
					                        Delete
				                        </a>
			                        </c:if>    
		                        </c:if>        
		                        <a class='btn btn-default' href="books">Back</a> 
		                    </c:otherwise>
		                </c:choose>
			        </c:when>      
		            <c:otherwise>
		            	<div class="alert alert-danger" style='text-align:center'>
	                        Book was not found<br/> 
	                        <a href='books'>Back</a>
	                    </div>
		            </c:otherwise>
		        </c:choose>
	            
            </div>
        </div>
    </section>
    
    
    <script>
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-red',
            radioClass: 'iradio_flat-red'
        });
        $('input[type="checkbox"].flat-green, input[type="radio"].flat-green').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        });
    </script>
    
    
    <%@include file="../footer.jsp" %>