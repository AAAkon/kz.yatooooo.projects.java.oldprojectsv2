<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <jsp:include page="../header.jsp" />
    
    <section class="content-header">
        <h1>Post panel</h1>
        <span></span>
    </section>
    
    <section class="content">
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title">
                    <c:choose>
                        <c:when test="${post != null}">
                            Delete post - 
                            <span class='text-primary'>${post.getTitle()} [id=${post.getId()}]</span>
                        </c:when>
                        <c:otherwise>
                            Delete post
                        </c:otherwise>
                    </c:choose>
                    
                </h3>
            </div>
            <div class="box-body">
                <c:choose>
                    <c:when test="${post != null}">
                        <c:choose>
                            <c:when test="${status == '#removed'}">
                                <div class="alert alert-primary" style='text-align:center'>
                                    Post was deleted successfully<br/> 
                                    <a href='posts'>Back</a>
                                </div>
                            </c:when>
                            <c:otherwise>
                                
                                <form action="" method='POST'>
                                    Are you sure want to delete ${post.getTitle()}?<br/>
                                    <div class='alert alert-danger'>
                                        Deleting of the post means removing all information that relates to this post!
                                    </div>
                                    <input class='btn btn-danger' type="submit" name="remove" value="Delete" />
                                    <a href="posts" class="btn btn-default">Back</a>
                                </form>
                            </c:otherwise>
                        </c:choose>
                        
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-danger" style='text-align:center'>
	                        post was not found<br/> 
	                        <a href='posts'>Back</a>
	                    </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </section>
    <%@include file="../footer.jsp" %>