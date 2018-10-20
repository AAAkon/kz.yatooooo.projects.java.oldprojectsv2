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
                <table class="table table-hover table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>Login</th>
                        <th>Name</th>
                        <th>Roles</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>#${user.getId()}</td>
                            <td>${user.getLogin()}</td>
                            <td>${user.getName()}</td>
                            <td>
                                <c:forEach var="role" items="${user.getRoles()}">
                                    <c:choose>
                                        <c:when test="${role.getId() == 1}">
                                            <span class='label label-danger'>${role.getName()}</span>                                            
                                        </c:when>
                                        <c:otherwise>
                                            <span class='label label-warning'>${role.getName()}</span>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </td>
                            <td>
                                <a href="adminEditUser?id=${user.getId()}" class='btn btn-success btn-xs'>
                                	<i class="fa fa-pencil"> </i>
                                	Edit
                                </a>
                                
                                <c:if test="${!user.isAdmin()}">
	                                <a href="adminDeleteUser?id=${user.getId()}" class='btn btn-danger btn-xs'>
	                                	<i class="fa fa-remove"> </i>
	                                    Delete
	                                </a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br/>
                <a href='adminAddUser' class='btn btn-primary'><i class='fa fa-plus'></i> Add user</a>
            </div>
        </div>
    </section>
    
    <%@include file="../footer.jsp" %>