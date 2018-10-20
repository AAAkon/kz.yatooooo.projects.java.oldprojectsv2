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
	                <c:when test="${bookRequest != null && bookRequest.getBook() != null}">
						<c:choose>
			                <c:when test="${status == '#saved'}">
			                    <div class="alert alert-primary" style='text-align:center'>
			                        All changes was saved<br/> 
			                        <a href='${redirectUrl }'>Back</a>
			                    </div>
			                </c:when>
			                <c:otherwise>
			                
			                	<h3>Book request info</h3>
			                
			                	<div class="form-group">
				                    <div class="form-control">
				                        Request status - <b>${bookRequest.getStatusString()}</b>
				                    </div>
				                </div>
				                			                
		                        <div class='row'>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Name *</label> 
		                                    <input type='text' class='form-control' name='name' value="${bookRequest.getBook().getName()}" disabled/>
		                                </div>
		                            </div>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Author *</label> 
		                                    <input type='text' class='form-control' name='author' value="${bookRequest.getBook().getAuthor()}" disabled/>
		                                </div>
		                            </div>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Edition *</label> 
		                                    <input type='text' class='form-control' name='edition' value="${bookRequest.getBook().getEdition()}" disabled/>
		                                </div>
		                            </div>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Stock *</label> 
		                                    <input type='text' class='form-control' name='stock' value="${bookRequest.getBook().getStock()}" disabled/>
		                                </div>
		                            </div>
		                       	</div>
		                       			                        
		                 	    <c:if test="${loggedUser.isAdmin() && bookRequest.getStatus() == bookRequest.getStatusCodePending()}">
			                 	    <h3>Accepting request</h3>
			                 	    <div class='row'>
			                            <div class='col-md-12 col-lg-6'>
					                 	    <form action="changeBookRequestStatus" method="post">
					                 	    	<div class='form-group'>
			                                    	<label>Return date *</label> 
						                 	    	<input type="hidden" name="newStatus" value="${bookRequest.getStatusCodeAccepted() }">
						                 	    	<input type="hidden" name="redirectUrl" value="${redirectUrl }">
						                 	    	<input type="hidden" name="id" value="${bookRequest.getId()}">
						                 	    	<input type="text" class="form-control datatime-picker" name="date" required>
								                </div>
								                <button class='btn btn-success' type="submit">
				                                	<i class="fa fa-check"> </i>
				                                	Accept request
				                                </button>
					                 	    </form>
				                 	    </div>
			                 	    </div>
			                 	    <hr/>
			                 	    <h3>Other operations</h3>
			                 	    <form action="changeBookRequestStatus" method="post" class="visible-lg-inline">
			                 	    	<input type="hidden" name="newStatus" value="${bookRequest.getStatusCodeDeclined() }">
			                 	    	<input type="hidden" name="redirectUrl" value="${redirectUrl }">
			                 	    	<input type="hidden" name="id" value="${bookRequest.getId()}">
						                <button class='btn btn-danger' type="submit">
		                                	<i class="fa fa-ban"> </i>
		                                	Decline request
		                                </button>
			                 	    </form>
		                        </c:if>   
		                                 
		                        <c:if test="${bookRequest.getUser().getId() == loggedUser.getId() && bookRequest.getStatus() == bookRequest.getStatusCodePending()}">
	                                <form action="changeBookRequestStatus" method="post" class="visible-lg-inline">
			                 	    	<input type="hidden" name="newStatus" value="${bookRequest.getStatusCodeRefused() }">
			                 	    	<input type="hidden" name="redirectUrl" value="${redirectUrl }">
			                 	    	<input type="hidden" name="id" value="${bookRequest.getId()}">
						                <button class='btn btn-danger' type="submit">
		                                	<i class="fa fa-remove"> </i>
		                                	Refuse request
		                                </button>
			                 	    </form>
		                        </c:if>
		                        
		                        <a class='btn btn-default' href="${redirectUrl }">Back</a> 

		                    </c:otherwise>
		                </c:choose>
			        </c:when>      
		            <c:otherwise>
		            	<div class="alert alert-danger" style='text-align:center'>
	                        Book/Request was not found<br/> 
	                        <a href='${redirectUrl }'>Back</a>
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