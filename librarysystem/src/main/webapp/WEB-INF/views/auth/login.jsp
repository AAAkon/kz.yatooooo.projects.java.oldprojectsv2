<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%@include file="miniHeader.jsp" %>
    
    <div class="login-box">
	  <div class="login-logo">
	    <a href="#"><b>Library</b>System</a>
	  </div>
	  <!-- /.login-logo -->
	  <div class="login-box-body">
	    <p class="login-box-msg">To continue, you must be logged in</p>
	    <c:if test="${not empty loginResult}">
	       <div class='alert alert-danger' style="text-align:center;">
	           <c:choose>
	               <c:when test="${loginResult == 'error'}">
	                   Invalid username / password
	               </c:when>
	               <c:otherwise>
	                   An unknown error occurred
	               </c:otherwise>
	           </c:choose>
               ${loginResult}
           </div>
	    </c:if>
	       
	    <form action="authLoginDo?redirectUrl=${redirectUrl}" method="post">
	      <div class="form-group has-feedback">
	        <input type="text" name='login' class="form-control" placeholder="Логин" value="${login}">
	        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	      </div>
	      <div class="form-group has-feedback">
	        <input type="password" name='password' class="form-control" placeholder="Пароль">
	        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
	      </div>
	      <div class="row">
	        <div class="col-xs-8">
	          <div class="checkbox icheck">
	            <label>
	              <input type="checkbox"> Remember me
	            </label>
	          </div>
	        </div>
	        <!-- /.col -->
	        <div class="col-xs-4">
	          <button type="submit" class="btn btn-primary btn-block btn-flat">Sign in</button>
	        </div>
	        <!-- /.col -->
	      </div>
	    </form>
	    
	    <a href="posts">Continue as guest</a>
	
	  </div>
	  <!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->
	
	<script>
	  $(function () {
	    $('input').iCheck({
	      checkboxClass: 'icheckbox_square-blue',
	      radioClass: 'iradio_square-blue',
	      increaseArea: '20%' // optional
	    });
	  });
	</script>
    
    <%@include file="miniFooter.jsp" %>