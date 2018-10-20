<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <jsp:include page="../header.jsp" />
    
    <section class="content-header">
        <h1>Posts panel</h1>
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
	                <c:when test="${loggedUser == null}">
	                    <div class="alert alert-danger" style='text-align:center'>
	                        User was not found<br/> 
	                        <a href='posts'>Back</a>
	                    </div>
	                </c:when>
	                <c:otherwise>
			            <c:choose>
			                <c:when test="${status == '#saved'}">
			                    <div class="alert alert-primary" style='text-align:center'>
			                        All changes was saved<br/> 
			                        <a href='posts'>Back</a>
			                    </div>
			                </c:when>
			                <c:otherwise>
		             
			                    <form action="editPost" method='POST'>
			                        <small>* - required fields</small>
			                        <input type='hidden' class='form-control' name='id' value="${post.getId()}" required/>
			                        <div class='row'>
			                            <div class='col-md-12 col-lg-6'>
			                                <div class='form-group'>
			                                    <label>Title *</label> 
			                                    <input type='text' class='form-control' name='title' value="${post.getTitle()}" required/>
			                                </div>
			                                <div class='form-group'>
			                                    <label>Text *</label> 
			                                    <textarea class='form-control' name="text" placeholder="Text here..." rows=3 required>${post.getText() }</textarea>      
			                                </div>
			                            </div>
			                        </div>
			                 	                        
			                        <input class='btn btn-primary' type="submit" value="Save" />
			                        <a class='btn btn-default' href="posts">Back</a>  
			                        
			                    </form>
			                    
			                </c:otherwise>
			            </c:choose>
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