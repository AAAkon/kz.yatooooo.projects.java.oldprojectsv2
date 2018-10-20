<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <%@include file="miniHeader.jsp" %>
    
    <div class="login-box">
      <div class="login-logo">
        <a href="#"><b>Library</b>System</a>
      </div>
      <!-- /.login-logo -->
      <div class="login-box-body">
        <div class='alert alert-danger' style="text-align:center;">
            Sorry, you do not have an access to this part
        </div>
        <center>
            <a href="${url}">Back to main</a>
        </center>
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