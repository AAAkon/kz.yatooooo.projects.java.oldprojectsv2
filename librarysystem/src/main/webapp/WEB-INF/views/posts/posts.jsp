<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <jsp:include page="../header.jsp" />
    
    <section class="content-header">
        <h1>Forum</h1>
    </section>
    
    <section class="content">
        <div class="box box-success">
            <div class="box-header with-border">
                <h3 class="box-title">${title }</h3>
            </div>
            <div class="box-body">
                   <c:if test="${posts.size() > 0 }">
                       <c:forEach var="post" items="${posts}">
                           <div class="post-block">
    		
				    		  <!-- Title -->
					          <h1 class="mt-4">
					          	${post.getTitle() }
					          </h1>
					          
					       
					          <!-- Edit/Delete post buttons -->
					          <c:if test="${loggedUser != null && loggedUser.getId() == post.getUser().getId() }">
					          
					          	<a href="editPost?id=${post.getId()}" class='btn btn-success btn-xs'>
                                	<i class="fa fa-pencil"> </i>
                                	Edit
                                </a>
                                <a href="deletePost?id=${post.getId()}" class='btn btn-danger btn-xs'>
                                	<i class="fa fa-remove"> </i>
                                    Delete
                                </a>

							  </c:if>
							  
							  
					          <!-- Author -->
					          <p class="lead">
					            by
					            <a href="#!">
					            	${post.getUser().getName()}
					            </a>
					          </p>
					
					          <!-- Date/Time -->
					          <p>
					          	Posted on 
					          	<fmt:formatDate pattern = "dd MMMM yyyy HH:mm" value = "${post.getDate() }" />
					          </p>
					
					          <hr>
									
							  <p>
							  	${post.getText() }
							  </p>
					
					          <!-- Comments Form -->
					          <c:if test="${loggedUser != null }">
						
					          	 <hr>
					          
					        	 <div class="card my-4">
						            <h5 class="card-header">Leave a Comment:</h5>
						            <div class="card-body">
						              <form method="post" action="addComment">
						                <div class="form-group">
						                  <input type=hidden name=post_id value="${post.getId()}" />
						                  <textarea class="form-control" name="text" rows="3" required></textarea>
						                </div>
						                <button type="submit" class="btn btn-primary">Submit</button>
						              </form>
						            </div>
						          </div>
					        	 
							  </c:if>
					          
					          <!-- Comment -->
					          <c:forEach var="comment" items="${post.getComments()}">

				        	
					        	
						          <div class="media mb-4">
						          
							          	<a href="#!" style="text-decoration: none">
							            	<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
							            </a>
							            <div class="media-body">
								          <a href="#!" style="text-decoration: none">
								              <h5 class="mt-0 d-inline">
								              	${comment.getUser().getName() }
								              </h5>
								          </a>
								          <small style="font-size:.8em;">
								          		<fmt:formatDate pattern = "dd MMMM yyyy HH:mm" value = "${comment.getDate() }" />
							              </small><br>
							              ${comment.getText() }
							            </div>
						            
						            <!-- Edit/Delete comment buttons -->
						            <c:if test="${loggedUser != null && loggedUser.getId() == comment.getUser().getId() }">

							            <a href="editComment?id=${comment.getId()}" class='btn btn-success btn-xs'>
		                                	<i class="fa fa-pencil"> </i>
		                                	Edit
		                                </a>
		                                <a href="deleteComment?id=${comment.getId()}" class='btn btn-danger btn-xs'>
		                                	<i class="fa fa-remove"> </i>
		                                    Delete
		                                </a>
		                                
				                    </c:if>
						            
						          </div>
							</c:forEach>    
					        <hr/>
                       </c:forEach>
                   </c:if>
                   <c:if test="${posts.size() == 0 }">
                   		No posts were found
                   </c:if>
             </div>
        </div>
    </section>
    
    <!-- Adding Post -->
     <c:if test="${loggedUser != null }">
	     <a href='addPost'
	     	title="Add post" 
	     	class='btn btn-info btn-lg add_post_btn'">
	     	<i class='fa fa-plus'></i> 
	     
	     </a>
     </c:if>
    
    <%@include file="../footer.jsp" %>
    
    
    
    
    
    
    
    
    
    
    
    
    
    