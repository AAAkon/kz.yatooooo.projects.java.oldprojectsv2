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
                    <c:choose>
                        <c:when test="${book != null}">
                            Delete book - 
                            <span class='text-primary'>${book.getName()} [id=${book.getId()}]</span>
                        </c:when>
                        <c:otherwise>
                            Delete book
                        </c:otherwise>
                    </c:choose>
                    
                </h3>
            </div>
            <div class="box-body">
                <c:choose>
                    <c:when test="${book != null}">
                        <c:choose>
                            <c:when test="${status == '#removed'}">
                                <div class="alert alert-primary" style='text-align:center'>
                                    Book was deleted successfully<br/> 
                                    <a href='books'>Back</a>
                                </div>
                            </c:when>
                            <c:otherwise>
                                
                                <form action="" method='POST'>
                                    Are you sure want to delete ${book.getName()}?<br/>
                                    <div class='alert alert-danger'>
                                        Deleting of the book means removing all information that relates to this book!
                                    </div>
                                    <input class='btn btn-danger' type="submit" name="remove" value="Delete" />
                                    <a href="books" class="btn btn-default">Back</a>
                                </form>
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
    <%@include file="../footer.jsp" %>