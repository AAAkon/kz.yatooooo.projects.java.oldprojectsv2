<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <jsp:include page="../header.jsp" />
    
    <section class="content-header">
        <h1>Admin panel</h1>
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
                    <c:when test="${user != null}">
			            <c:choose>
			                <c:when test="${status == '#saved'}">
			                    <div class="alert alert-primary" style='text-align:center'>
			                        All changes was saved<br/> 
			                        <a href='adminUsers'>Back</a>
			                    </div>
			                </c:when>
			                <c:otherwise>
			                    
			                    <c:if test="${status == '#password_error' }">
			                        <div class='alert alert-danger'>
			                            Passwords are not equal
			                        </div>
			                    </c:if>
			                    	          	                    
			                    <c:if test="${status == '#login_exists' }">
			                        <div class='alert alert-danger'>
			                            Login already exists
			                        </div>
			                    </c:if>
			                    
			                    <c:if test="${status == '#not_chosen' }">
			                        <div class='alert alert-danger'>
			                            User has to have exactly one role
			                        </div>
			                    </c:if>
			                    	                    
			                    <form action="adminEditUser" method='POST'>
			                        <small>* - required fields</small>
			                        <input type="hidden" name="id" value="${user.getId()}"/>
			                        <div class='row'>
			                            <div class='col-md-12 col-lg-6'>
			                                <div class='form-group'>
			                                    <label>Login *</label> 
			                                    <input type='text' class='form-control' name='login' value="${user.getLogin()}" required/>
			                                </div>
			                            </div>
			                            <div class='col-md-12 col-lg-6'>
			                                <div class='form-group'>
			                                    <label>Name *</label> 
			                                    <input type='text' class='form-control' name='name' value="${user.getName()}" required/>
			                                </div>
			                            </div>
			                            <div class='col-md-12 col-lg-6'>
			                                <div class='form-group'>
			                                    <label>Password</label> 
			                                    <input type='password' class='form-control' name='password' value=""/>
			                                    <small>Leave this field if you do not want to change the password</small>
			                                </div>
			                            </div>
			                            <div class='col-md-12 col-lg-6'>
			                                <div class='form-group'>
			                                    <label>Re-password</label> 
			                                    <input type='password' class='form-control' name='repassword' value=""/>
			                                </div>
			                            </div>
			                        </div>
			                        
			                        <div class="row"> 
			                        
			                            <div class='col-md-12 col-lg-6'>
			                            
			                            	<hr/>
			                                <div class='form-group'>
			                                
			                                    <label>Roles</label><br/> 
			                                    <input type='hidden' name="roles" value='0' />
			                                    
			                                    <c:forEach items="${allRoles}" var="role">
			                                    
			                                        <c:set var="className" value="flat-green"/>
			                                        <c:if test="${role.id == 1}">
			                                            <c:set var="className" value="flat-red"/>
			                                        </c:if>
			                                        
			                                        <c:set var="checked" value=""/>
			                                        <c:if test="${user.isRole(role.id)}">
			                                            <c:set var="checked" value="checked='checked'"/>
			                                        </c:if>
			                                            
			                                        <label style='cursor:pointer'>
		                                        		<input type="checkbox" class="${className}" ${checked} name="roles" value="${role.getId()}"  />
		                                            	${role.getName()}            
			                                        </label><br/>
			                                        
			                                    </c:forEach>
			                                    
			                                </div>
			                                
			                            </div>
			                            
			                        </div>
			                        
			                        <input class='btn btn-primary' type="submit" value="Save" />
			                        <a class='btn btn-default' href="adminUsers">Back</a>  
			                        
			                    </form>
			                    
			                </c:otherwise>
			            </c:choose>
			    	</c:when>
	            	<c:otherwise>
                        <div class="alert alert-danger" style='text-align:center'>
	                        User was not found<br/> 
	                        <a href='adminUsers'>Back</a>
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