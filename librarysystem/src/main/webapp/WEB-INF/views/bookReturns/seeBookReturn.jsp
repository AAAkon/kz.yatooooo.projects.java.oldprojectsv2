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
	                <c:when test="${bookReturn != null && bookReturn.getBook() != null}">
						<c:choose>
			                <c:when test="${status == '#saved'}">
			                    <div class="alert alert-primary" style='text-align:center'>
			                        All changes was saved<br/> 
			                        <a href='${redirectUrl }'>Back</a>
			                    </div>
			                </c:when>
			                <c:otherwise>
			                			                
			                	<div class="form-group">
				                    <div class="form-control">
				                        Return status - <b>${bookReturn.getStatusString()}</b>
				                    </div>
				                </div>
				                			                
		                        <div class='row'>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Name *</label> 
		                                    <input type='text' class='form-control' name='name' value="${bookReturn.getBook().getName()}" disabled/>
		                                </div>
		                            </div>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Author *</label> 
		                                    <input type='text' class='form-control' name='author' value="${bookReturn.getBook().getAuthor()}" disabled/>
		                                </div>
		                            </div>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Edition *</label> 
		                                    <input type='text' class='form-control' name='edition' value="${bookReturn.getBook().getEdition()}" disabled/>
		                                </div>
		                            </div>
		                            <div class='col-md-12 col-lg-6'>
		                                <div class='form-group'>
		                                    <label>Stock *</label> 
		                                    <input type='text' class='form-control' name='stock' value="${bookReturn.getBook().getStock()}" disabled/>
		                                </div>
		                            </div>
		                       	</div>
		                       			                        
		                 	    <c:if test="${loggedUser.isAdmin()}">
			                 	    <c:if test="${bookReturn.getStatus() != bookReturn.getStatusCodeAccepted()}">
			                 	    	<form action="changeBookReturnStatus" method="post" class="visible-lg-inline">
				                 	    	<input type="hidden" name="newStatus" value="${bookReturn.getStatusCodeAccepted() }">
				                 	    	<input type="hidden" name="redirectUrl" value="${redirectUrl }">
				                 	    	<input type="hidden" name="id" value="${bookReturn.getId()}">
							                <button class='btn btn-success' type="submit">
			                                	<i class="fa fa-check"> </i>
			                                	Accept return
			                                </button>
				                 	    </form>
			                 	    </c:if>
			                 	    <c:if test="${bookReturn.getStatus() == bookReturn.getStatusCodePending()}">
			                 	    	<form action="changeBookReturnStatus" method="post" class="visible-lg-inline">
				                 	    	<input type="hidden" name="newStatus" value="${bookReturn.getStatusCodePenalty() }">
				                 	    	<input type="hidden" name="redirectUrl" value="${redirectUrl }">
				                 	    	<input type="hidden" name="id" value="${bookReturn.getId()}">
							                <button class='btn btn-danger' type="submit">
			                                	<i class="fa fa-ban"> </i>
			                                	Penalty
			                                </button>
				                 	    </form>
			                 	    </c:if>
		                        </c:if>   
			                        
		                        <a class='btn btn-default' href="${redirectUrl }">Back</a> 

		                    </c:otherwise>
		                </c:choose>
			        </c:when>      
		            <c:otherwise>
		            	<div class="alert alert-danger" style='text-align:center'>
	                        Book/Return was not found<br/> 
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