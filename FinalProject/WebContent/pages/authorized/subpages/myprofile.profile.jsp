<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
    <c:forEach items="${user}" var="user">     
  	 <div class="well profile">
          <div class="col-sm-12">
          	<div class="col-lg-5 col-md-12 col-sm-12 col-xs-12">
                  <figure>
                      <img src="<c:out value="${user.imagepath}"/>" width="250px" height="250px">
                      <figcaption class="ratings">
                          <p>Ratings
                          <a href="#">
                              <span class="fa fa-star"></span>
                          </a>
                          <a href="#">
                              <span class="fa fa-star"></span>
                          </a>
                          <a href="#">
                              <span class="fa fa-star"></span>
                          </a>
                          <a href="#">
                              <span class="fa fa-star"></span>
                          </a>
                          <a href="#">
                               <span class="fa fa-star"></span>
                          </a> 
                          </p>
                      </figcaption>
                  </figure>
              </div>
              <div class="col-lg-7 col-md-12 col-sm-12 col-xs-12 ">
                  <h2 class="profile-info"><c:out value="${user.name}"/> <c:out value="${user.surname}" /></h2>
                  <p><strong>City: </strong><span class="profile-info"><c:out value="${user.city }"/></span></p>
                  <p><strong>Address: </strong><span class="profile-info"><c:out value="${user.address }"/></span></p>
                  <p><strong>Phone no: </strong><span class="profile-info"><c:out value="${user.phoneno }"/></span></p>
                  <p><strong>Email: </strong><span class="profile-info"><c:out value="${user.email }"/></span></p>
                  <p>
                   <c:if test="${user.isright==true}">
                       <span class="tags isright">Right user</span>
                   </c:if>
                   <c:if test="${user.isdeleted==true}">
                       <span class="tags isdeleted">Deleted user</span>
                   </c:if>
                   <c:if test="${user.isadmin==true}">
                       <span class="tags isadmin">Admin</span>
                   </c:if> 
                  </p>
              </div>             
          </div>            
          <div class="col-xs-12 divider text-center">
              <div class="col-xs-12 col-sm-4 emphasis">
                  <h2><strong> 20,7K </strong></h2>                    
                  <p><small>Followers</small></p>
                  <button class="btn btn-success btn-block"><span class="fa fa-plus-circle"></span> Follow </button>
              </div>
              <div class="col-xs-12 col-sm-4 emphasis">
                  <h2><strong>245</strong></h2>                    
                  <p><small>Following</small></p>
                  <button class="btn btn-info btn-block"><span class="fa fa-user"></span> View Profile </button>
              </div>
              <div class="col-xs-12 col-sm-4 emphasis">
              		<h2><strong>In this section</strong></h2>                    
                  	<p><small>You can edit your profile</small></p>
                 	<button class="btn btn-warning btn-block" data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block"><span class="glyphicon glyphicon-pencil">
                 	</span>Edit
                 	</button>
              </div>
          </div>
  	 </div>
  	 
  	 
  	 			
<!-- line modal -->
<div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
  <div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">x</span><span class="sr-only">Close</span></button>
			<h3 class="modal-title" id="lineModalLabel">Edit Modal</h3>
		</div>
		<form action="edit" method="post" enctype="multipart/form-data">
		<div class="modal-body">
			
            <!-- content goes here -->
			<div class="form-container">
				
					<div class="form-group files" >
				    	<input  id="1" type="file" name="image1">
		    			<img id="avatar1" src="<c:out value="${user.imagepath}" />" alt="1" width="90%"  height="auto"/>
				  	</div>
					<div class="form-group">
				    	<label for="name">Name:</label>
				    	<input type="text" class="form-control" name="name" required value="<c:out value="${user.name}" />">
				 	</div>
				 	<div class="form-group">
				    	<label for="name">Surname:</label>
				    	<input type="text" class="form-control" name="surname" required value="<c:out value="${user.surname}" />"> 
				 	</div>
				 	<div class="form-group">
				    	<label for="city">City:</label>
				    	<input type="text" class="form-control" name="city" required value="<c:out value="${user.city}" />">
				  	</div>
				  	<div class="form-group">
				    	<label for="address">Address:</label>
				    	<input type="text" class="form-control" name="address" required value="<c:out value="${user.address}" />">
				  	</div>
				  	<div class="form-group">
				    	<label for="phoneNo">Phone no:</label>
				    	<input type="text" class="form-control" name="phoneNo" maxlength="11" required value="<c:out value="${user.phoneno}" />">
				  	</div>
				  	<div class="form-group">
				    	<label for="email">Email address:</label>
				    	<input type="email" class="form-control" name="email" required value="<c:out value="${user.email}" />">
				  	</div>
				  	<div class="form-group">
				    	<label for="login">Username:</label>
				    	<input type="text" class="form-control" name="username" required value="<c:out value="${user.username}" />">
				  	</div>
				  <div class="form-group">
				    <label for="pwd">Password:</label>
				    <input type="password" class="form-control" name="password" >
				  </div>
				  <div class="form-group">
				    <label for="pwd">Confirm password:</label>
				    <input type="password" class="form-control" name="password2">
				  </div>
				
			</div>

		</div>
		<div class="modal-footer">
			<div class="btn-group btn-group-justified" role="group" aria-label="group button">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
				</div>
				<div class="btn-group" role="group">
					<button type="submit" id="saveImage" class="btn btn-default btn-hover-green" data-action="save" role="button">Save</button>
				</div>
			</div>
		</div>
		</form>
	</div>
  </div>
</div>
 </c:forEach>
 </div>